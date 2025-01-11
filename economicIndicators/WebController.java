import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class WebController {
    private List<Date> dates = new ArrayList<>();
    private List<Double> gdpValues = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        return "dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add your data processing logic here
        model.addAttribute("dates", dates);
        model.addAttribute("gdpData", gdpValues);
        return "dashboard";
    }
}


