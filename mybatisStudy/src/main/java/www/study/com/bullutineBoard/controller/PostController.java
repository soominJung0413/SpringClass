package www.study.com.bullutineBoard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import www.study.com.bullutineBoard.model.PostVO;
import www.study.com.bullutineBoard.model.ReplyVO;
import www.study.com.bullutineBoard.service.PostService;
import www.study.com.framework.model.Criteria;
import www.study.com.framework.util.Pair;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class PostController {
	private PostService service;
	
	@GetMapping("/list")
	public void list(Criteria criteria,Model model) {
		Pair<List<ReplyVO>, Integer> listReplyWithTot = service.getPostByPaging(criteria);
				model.addAttribute("list", listReplyWithTot.getFirst());
		model.addAttribute("pageMaker", new Criteria(criteria.getPageNo(), criteria.getAmount(), listReplyWithTot.getSecond()));
	}

	//@ModelAttribute : 입출력 공히 작동
	@GetMapping("/findPostById")
	public String findPostById(@RequestParam("hierarchyId") String hierarchyId, @ModelAttribute("cri") Criteria criteria, Model model) {
		ReplyVO obj = service.findById(hierarchyId);
		model.addAttribute("post", obj);
		return "board/PostDetail";
	}

	//register 화면 띄우기
	@GetMapping("/register")
	public void openRegisterPage() {
	}
	
	@PostMapping("/register")
	public String registerPost(PostVO post, RedirectAttributes rttr) {
		service.insertPost(post);
		rttr.addFlashAttribute("result", post.getHierarchyId());
		return "redirect:/board/list";
	}
	
	@GetMapping("/modify")
	public String openModifyPage(@RequestParam("hierarchyId") String hierarchyId, @ModelAttribute("cri") Criteria criteria, Model model) {
		ReplyVO obj = service.findById(hierarchyId);
		model.addAttribute("post", obj);
		return "board/modifyPost";
	}
	
	@PostMapping("/modify")
	public String modifyPost(PostVO post, @ModelAttribute("cri") Criteria criteria, RedirectAttributes rttr) {
		service.updatePost(post);
		rttr.addFlashAttribute("result", "success");
		rttr.addAttribute("pageNo", criteria.getPageNo());//response-header
		rttr.addAttribute("amount", criteria.getAmount());
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String removePost(PostVO post, @ModelAttribute("cri") Criteria criteria, RedirectAttributes rttr) {
		service.removePost(post);
		rttr.addFlashAttribute("result", "remove success");
		rttr.addAttribute("pageNo", criteria.getPageNo());//response-header
		rttr.addAttribute("amount", criteria.getAmount());
		return "redirect:/board/list";
	}
}
