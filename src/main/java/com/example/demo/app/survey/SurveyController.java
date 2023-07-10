package com.example.demo.app.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	// /survey/formへの遷移処理
	@GetMapping("/form")
	public String form(SurveyForm surveyForm, Model model) {
		model.addAttribute("title", "Survey Form");
		return "survey/form";
	}

	// /survey/confirmから/survey/formへのバック処理
	@PostMapping("/form")
	public String backToForm(SurveyForm surveyForm, Model model) {
		model.addAttribute("title", "Survey Form");
		return "survey/form";
	}
	
	
	// /survey/confirmページへ遷移する処理
	@PostMapping("/confirm")
	public String confirm(@Validated SurveyForm surveyForm, 
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Survey Form");
			return "survey/form";
		}
		model.addAttribute("title", "Confirm Page");
		return "survey/confirm";
	}
	
	
	// /survey/confirmから本送信した際の遷移処理
	@PostMapping("/complete")
	public String complete(@Validated SurveyForm surveyForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		// 入力値にエラー(バリデーションが働いたら)があれば
		if(result.hasErrors()) {
			model.addAttribute("title", "SurveyForm");
			return "survey/form";  // survey/formへ戻してやる
		}
		// 特にエラーがなければ、completeというキーが渡ってきたら"登録完了！"の文字を渡して、/survey/formへリダイレクトさせる
		redirectAttributes.addFlashAttribute("complete", "登録完了！");
		return "redirect:/survey/form";
	}
}
