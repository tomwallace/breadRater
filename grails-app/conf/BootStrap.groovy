import com.tomwallace.breadrater.Evaluation
import com.tomwallace.breadrater.Loaf
import com.tomwallace.breadrater.BreadRecipe

class BootStrap {

    def init = { servletContext ->
		Date now = new Date()
		Evaluation eval = new Evaluation(dateEvaluated: now, score: 5).save(failOnError: true)
		Loaf loaf = new Loaf(baker: 'Tom Wallace', dateBaked: now, evaluations: [eval]).save(failOnError: true)
		new BreadRecipe(name: 'New England Sourdough', type: 'Sourdough', description: 'From Hammelmanns Bread', loaves: [loaf]).save(failOnError: true)
	}
    def destroy = {
    }
}
