package www.study.com.bullutineBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import www.study.com.bullutineBoard.model.PostVO;
import www.study.com.bullutineBoard.model.ReplyVO;
import www.study.com.bullutineBoard.service.PostService;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class PostController {
	private PostService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getAll());
	}

	//@ModelAttribute : 입출력 공히 작동
	@GetMapping("/findPostById")
	public String findPostById(@RequestParam("hierarchyId") String hierarchyId, Model model) {
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
	public String openModifyPage(@RequestParam("hierarchyId") String hierarchyId, Model model) {
		ReplyVO obj = service.findById(hierarchyId);
		model.addAttribute("post", obj);
		return "board/modifyPost";
	}
	
	@PostMapping("/update")
	public String modifyPost(PostVO post, RedirectAttributes rttr) {
		service.updatePost(post);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
	}
}
