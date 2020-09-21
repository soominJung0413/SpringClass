package www.study.com.bulletinboard.controll;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import www.study.com.bulletinboard.model.PostVO;
import www.study.com.bulletinboard.model.ReplyVO;
import www.study.com.bulletinboard.service.PostService;
import www.study.com.framework.model.SearchCriteria;
import www.study.com.framework.util.Pair;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class PostController {
	private PostService service;
	
	@GetMapping("/list")
	public void list(SearchCriteria criteria, Model model) {
		Pair<List<ReplyVO>, Long> listReplyWithTot = service.getPostByPaging(criteria);
		model.addAttribute("list", listReplyWithTot.getFirst());
		model.addAttribute("pageMaker",
				new SearchCriteria(criteria, listReplyWithTot.getSecond()));
	}

	//register 화면 띄우기
	@GetMapping("/register")
	public ModelAndView openRegisterPage() {
		//ModelAndView 소개 드리는 이유... RestController에서 JSP로 반환 주고자 할때 활용
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/register");
		return mav;
	}

	@PostMapping("/register")
	public String registerPost(PostVO post, RedirectAttributes rttr) {
		service.insertPost(post);
		rttr.addFlashAttribute("result", post.getHierarchyId());
		return "redirect:/board/list";
	}

	//@ModelAttribute : 입출력 공히 작동
	@GetMapping("/findPostById")
	public String findPostById(@RequestParam("hierarchyId") String hierarchyId, @ModelAttribute("cri") SearchCriteria criteria, Model model) {
		ReplyVO obj = service.findById(hierarchyId);
		model.addAttribute("post", obj);
		return "board/PostDetail";
	}

	@GetMapping("/modify")
	public String openModifyPage(@RequestParam("hierarchyId") String hierarchyId, @ModelAttribute("cri") SearchCriteria criteria, Model model) {
		ReplyVO obj = service.findById(hierarchyId);
		model.addAttribute("post", obj);
		return "board/modifyPost";
	}

	@PostMapping("/modify")
	public String modifyPost(PostVO post, @ModelAttribute("cri") SearchCriteria criteria, RedirectAttributes rttr) {
		service.updatePost(post);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/list" + criteria.getListLink();
	}

	@PostMapping("/remove")
	public String removePost(@RequestParam("hierarchyId") String hierarchyId, @ModelAttribute("cri") SearchCriteria criteria, RedirectAttributes rttr) {
		service.removePost(hierarchyId);
		rttr.addFlashAttribute("result", "remove success");
		return "redirect:/board/list" + criteria.getListLink();
	}

}
