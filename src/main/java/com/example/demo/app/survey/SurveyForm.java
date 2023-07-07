package com.example.demo.app.survey;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SurveyForm {

	// 各種フィールド
	
	@Min(0)
	@Max(150)
	@NotNull
	private int age;
	
	@NotNull
	private int satisfaction;
	
	@NotNull
	private String comment;
	
	// コンストラクタ
	public SurveyForm() {
	}
	
	// 各種ゲッターセッター
	public int getAge() {
		return age;
	}
	public int getSatisfaction() {
		return satisfaction;
	}
	public String getComment() {
		return comment;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setSatisfactino(int satisfaction) {
		this.satisfaction = satisfaction;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
