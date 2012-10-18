package breadrater

class Loaf {
	String baker
	Date dateBaked
	String comments
	
	static hasMany = [evaluations: Evaluation]
	
    static constraints = {
		baker nullable: false, blank: false
		dateBaked nullable: false
		comments nullable: true
    }
}
