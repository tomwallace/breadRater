package breadrater

class BreadRecipe {
    String name
    String type
    String description

    static constraints = {
        name nullable: false, blank: false
        type nullable: false, blank: false
        description nullable: true
    }
}
