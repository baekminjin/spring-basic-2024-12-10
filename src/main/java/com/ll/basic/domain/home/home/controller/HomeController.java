package com.ll.basic.domain.home.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
	private int age = 22;

	@GetMapping("/")
	@ResponseBody
	public String showMain() {
		return "안녕하세요.";
	}

	@GetMapping("/about")
	@ResponseBody
	public String showAbout() {
		return "저는 홍길동입니다.";
	}

	@GetMapping("/ageUp")
	@ResponseBody
	public int getAgeAndUp() {
		return age++;
	}

	@GetMapping("/boolean")
	@ResponseBody
	public boolean getBoolean() {
		return true;
	}

	@GetMapping("/byte")
	@ResponseBody
	public byte getByte() {
		return 127;
	}

	@GetMapping("/short")
	@ResponseBody
	public short getShort() {
		return 32000;
	}

	@GetMapping("/long")
	@ResponseBody
	public long getLong() {
		return 100_000_000_000_000L;
	}

	@GetMapping("/char")
	@ResponseBody
	public char getChar() {
		return '꽑';
	}

	@GetMapping("/float")
	@ResponseBody
	public float getFloat() {
		return 3.14f;
	}

	@GetMapping("/double")
	@ResponseBody
	public double getDouble() {
		return 3.141592;
	}

	@GetMapping("/array")
	@ResponseBody
	public String[] getArray() {
		String[] arr = {"a", "b", "c"};

		return arr;
	}

	@GetMapping("/list")
	@ResponseBody
	public List<String> getList() {
		return List.of("a", "b", "c");
	}

	@GetMapping("/map")
	@ResponseBody
	public Map<String, String> getMap() {
		return Map.of("name", "Paul", "hobby", "reading");
	}

	@GetMapping("/article")
	@ResponseBody
	public Article getArticle() {
		//return new Article("제목", "내용"); //리모콘
		return Article
				.builder() //객체 생성 필드에서 원하는 것을 가져온다
				.title("제목")
				.body("내용")
				.build();
	}

	@GetMapping("/articleList")
	@ResponseBody //
	public List<Article> getArticles() {
		return List.of(
				Article.builder().title("제목1").body("내용1").build(),
				Article.builder().title("제목2").body("내용2").build()
		);
	}

	@GetMapping("/articleMap") //key , value
	@ResponseBody
	public Map<String, Article> articleMap() {
		return Map.of(
				"article1", Article.builder().title("제목1").body("내용1").build(),
				"article2", Article.builder().title("제목2").body("내용2").build()
		);
	}
}

//@AllArgsConstructor//전부
//@RequiredArgsConstructor //필수인 것만 받고 싶다 (final)
@Builder
@Getter //public으로 안해도 된다.
class Article{
	@Builder.Default //기본값을 사용할 수 있게 하는 기능
	private long id = 1L;

	private String title;
	private String body;

	@Builder.Default
	private boolean published = true;

}
