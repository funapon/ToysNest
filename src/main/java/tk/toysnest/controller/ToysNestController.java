package tk.toysnest.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
    private final ResourceLoader resourceLoader;
    @GetMapping
    public String index() {
        return "page/index";
    }
    @GetMapping("/art_gallery")
    public String artGalleryIndex(Model model) throws IOException {
        Resource folder = resourceLoader.getResource("classpath:templates/page/art_gallery");
        List<String> artGalleryTitles =
                Stream.of(folder.getFile().listFiles())
                     .map(File::getName)
                     .map(fileName -> fileName.replaceAll(".html$", ""))
                     .collect(Collectors.toList());
        model.addAttribute("artGalleryTitles", artGalleryTitles);
    	return "page/art_gallery/index";
    }
    @GetMapping("/art_gallery/{title}")
    public String getToTitle(@PathVariable("title") String title) {
        return String.format("page/art_gallery/%s", title);
    }
}
