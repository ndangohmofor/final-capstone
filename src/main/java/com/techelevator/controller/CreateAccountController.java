package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.dao.CreateAccountDao;
import com.techelevator.model.Account;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.MULTIPART_FORM_DATA_VALUE;

@Controller
public class CreateAccountController {

    @Autowired
    private AuthProvider auth;
    @Autowired
    private CreateAccountDao createAccountDao;


    //GET type of web service to load createAccount.jsp file in browser
    @RequestMapping(path="/createAccount", method= RequestMethod.GET)
    public String createAccount(ModelMap modelHolder, HttpSession session) throws UnauthorizedException {
        if (auth.userHasRole(new String[] { "admin", "user" })) {
            if (!modelHolder.containsAttribute("account")) {
                modelHolder.put("account", new Account());
            }
            User user = (User) session.getAttribute("user");
            long userId = user.getId();

           long id = createAccountDao.checkAccountExists(userId);
            if(id == 0) {
                return "createAccount";
            }else {
                return "redirect:/";
            }
        } else {
            throw new UnauthorizedException();
        }

    }
    //POST type of web service to receive data from createAccount.jsp file in browser
    @RequestMapping(path="/createAccount", method=RequestMethod.POST, consumes = {MULTIPART_FORM_DATA_VALUE})
    public String submitAccount(@Valid @ModelAttribute("account") Account account, BindingResult result,
                                @RequestParam("photoContainer") MultipartFile photoContainer, RedirectAttributes flash,
                                HttpSession session) throws IOException {
        if (result.hasErrors()) {
            flash.addFlashAttribute("account", account);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "account", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/createAccount";
        }
        User user = (User) session.getAttribute("user");
        long userId = user.getId();
        account.setUserId(userId);
        System.out.println("photocontainer data is "+photoContainer);
        if(photoContainer.isEmpty()){
             account.setPhoto(null);
        }else{
            account.setPhoto(photoContainer.getBytes());
        }
        long newId = createAccountDao.createAccount(account);
        if(newId > 0){
            return "redirect:/";
        }else{
            return "redirect:/createAccount";
        }

    }
}

