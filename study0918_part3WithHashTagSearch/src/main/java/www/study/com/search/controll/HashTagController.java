package www.study.com.search.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.study.com.search.service.HashTagService;

@RequestMapping("/hashtag/*")
@RestController
/* service를 찾아서 연결 시켜주는 방법에는 두가지가 있는 데
 * setter injection(Autowire), 생성자 주입(@AllArgsConstructor)
 * */
public class HashTagController {

	@GetMapping(value = "analyze/{analysisTarget}", produces = "text/plain; charset=UTF-8")
	public String analysisTarget(@PathVariable("analysisTarget") String analysisTarget) {
		return HashTagService.analysisTarget(analysisTarget);
	}
}
