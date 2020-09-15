package www.study.com.bullutineBoard.controller;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import www.study.com.bullutineBoard.model.ReplyVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PostControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() {
		try {
			MockHttpServletRequestBuilder mockHttpServletRequestBuilder 
				= MockMvcRequestBuilders.get("/board/list");
			mockHttpServletRequestBuilder.param("pageNo", "2");
			mockHttpServletRequestBuilder.param("amount", "10");
			ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
			MvcResult mvcResult = resultActions.andReturn();
			ModelAndView modelAndView = mvcResult.getModelAndView();
			Map<String, Object> mav = modelAndView.getModel();
			List<ReplyVO> listResult = (List<ReplyVO>) mav.get("list");
			for (ReplyVO obj : listResult) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
