package com.example.spring_crud_demo1.web.issue;

import com.example.spring_crud_demo1.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public String showList(Model model, @ModelAttribute("complete") String complete) {
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm issueForm) {
        return "issues/creationForm";
    }

    @PostMapping("/creationForm")
    public String goBackCreationForm(@ModelAttribute IssueForm issueForm) {
        return "issues/creationForm";
    }

    @PostMapping("/confirm")
    public String confirm(@Validated IssueForm issueForm, BindingResult result) {
        if(result.hasErrors()) {
            return showCreationForm(issueForm);
        }
        return "issues/confirm";
    }

    @PostMapping("/complete")
    public String complete(@Validated IssueForm issueForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return showCreationForm(issueForm);
        }
        issueService.create(issueForm.getSummary(), issueForm.getDescription());
        redirectAttributes.addFlashAttribute("complete", "作成が完了しました");
        return "redirect:/issues";
    }

    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") int issueId, Model model) {
        model.addAttribute("issueObject", issueService.findById(issueId));
        return "issues/detail";
    }

    @PostMapping("/deleteConfirm")
    public String deleteConfirm(@RequestParam("issueId") int issueId, Model model) {
        model.addAttribute("issueId", issueId);
        model.addAttribute("issueObject", issueService.findById(issueId));
        return "issues/deleteConfirm";
    }

    //TODO issueIdのバリデーションチェックしたいかも。
    @PostMapping("/deleteComplete")
    public String deleteComplete(@RequestParam("issueId") int issueId, RedirectAttributes redirectAttributes) {
        issueService.delete(issueId);
        redirectAttributes.addFlashAttribute("complete", "削除が完了しました");
        return "redirect:/issues";
    }

}
