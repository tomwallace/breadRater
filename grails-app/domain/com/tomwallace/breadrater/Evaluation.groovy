package com.tomwallace.breadrater

class Evaluation {
	Date dateEvaluated
	Integer score
	String evaluator
	
    static constraints = {
		dateEvaluated nullable: false
		score nullable: false, min: 1, max: 5
		evaluator nullable: true
	}
}
