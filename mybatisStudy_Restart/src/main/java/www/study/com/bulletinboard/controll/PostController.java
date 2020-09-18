package www.study.com.bulletinboard.controll;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
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
		model.addAttribute("pageMaker", new SearchCriteria(criteria, listReplyWithTot.getSecond()));
	}

	/*
	 * // @ModelAttribute : 입출력 공히 작동
	 * 
	 * @GetMapping("/findPostById") public String
	 * findPostById(@RequestParam("hierarchyId") String hierarchyId,
	 * 
	 * @ModelAttribute("cri") SearchCriteria criteria, Model model) {// 다형성, 넘어오는
	 * 객체는 자식객체 ReplyVO obj = service.findById(hierarchyId);
	 * model.addAttribute("post", obj); return "board/PostDetail"; }
	 * 
	 * // register 화면 띄우기
	 * 
	 * @GetMapping("/register") public void openRegisterPage() { }
	 * 
	 * @PostMapping("/register") public String registerPost(PostVO post,
	 * RedirectAttributes rttr) { service.insertPost(post);
	 * rttr.addFlashAttribute("result", post.getHierarchyId()); return
	 * "redirect:/board/list"; }
	 * 
	 * @GetMapping("/modify") public String
	 * openModifyPage(@RequestParam("hierarchyId") String hierarchyId,
	 * 
	 * @ModelAttribute("cri") SearchCriteria criteria, Model model) { ReplyVO obj =
	 * service.findById(hierarchyId); model.addAttribute("post", obj); return
	 * "board/modifyPost"; }
	 * 
	 * @PostMapping("/modify") public String modifyPost(PostVO
	 * post, @ModelAttribute("cri") SearchCriteria criteria, RedirectAttributes
	 * rttr) { service.updatePost(post); rttr.addFlashAttribute("result",
	 * "success"); return "redirect:/board/list" + criteria.getListLink(); }
	 * 
	 * @PostMapping("/remove") public String removePost(PostVO
	 * post, @ModelAttribute("cri") SearchCriteria criteria, RedirectAttributes
	 * rttr) { service.removePost(post); rttr.addFlashAttribute("result",
	 * "remove success"); return "redirect:/board/list" + criteria.getListLink(); }
	 */
}
