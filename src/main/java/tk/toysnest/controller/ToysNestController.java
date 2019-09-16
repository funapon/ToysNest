package tk.toysnest.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/toysnest")
@RequiredArgsConstructor
public class ToysNestController {
    @GetMapping
    public String index() {
        return "page/index";
    }
    @GetMapping("/art_gallery")
    public String artGalleryIndex(Model model) throws IOException {
        List<String> artGalleryTitles =
                Arrays.asList("coordinates",
                        "functions",
                        "mouse_ellipse",
                        "no_loop",
                        "redraw",
                        "setup_and_draw",
                        "width_and_height");
        model.addAttribute("artGalleryTitles", artGalleryTitles);
    	return "page/art_gallery/index";
    }
    @GetMapping("/art_gallery/{title}")
    public String getToTitle(@PathVariable("title") String title) {
        return String.format("page/art_gallery/%s", title);
    }
}
