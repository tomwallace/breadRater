package com.tomwallace.breadrater

class BreadRecipe {
    String name
    String type
    String description

	static hasMany = [loaves: Loaf]
	
    static constraints = {
        name nullable: false, blank: false
        type nullable: false, blank: false
        description nullable: true
    }
}
