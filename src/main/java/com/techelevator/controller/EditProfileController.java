package com.techelevator.controller;

import com.techelevator.dao.EditProfileDao;
import com.techelevator.model.User;
import com.techelevator.model.UserProfile;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.MULTIPART_FORM_DATA_VALUE;

@Controller
public class EditProfileController {

    @Autowired
    EditProfileDao editProfileDao;

    @RequestMapping(path = "/updateProfile", method = RequestMethod.GET)
    public String displayUpdateForm(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("user");
        UserProfile userProfile = editProfileDao.displayProfileByUserId(user.getId());
        if (!modelMap.containsAttribute("profile")) {
            modelMap.put("profile", userProfile);
        }
        return "updateProfile";
    }

    @RequestMapping(path = "/updateProfile", method = RequestMethod.POST)
    public String submitUpdateProfile(@Valid @ModelAttribute UserProfile userProfile,
                                      HttpSession session, BindingResult result, RedirectAttributes flash) {
        flash.addFlashAttribute("profile", userProfile);
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "profile", result);
            flash.addFlashAttribute("profile", userProfile);
            flash.addFlashAttribute("message", "Please Fill in Empty boxes");
            return "redirect:/updateProfile";
        }
        User user = (User) session.getAttribute("user");
        editProfileDao.updateProfile(userProfile.getFirstName(), userProfile.getLastName(), userProfile.getGoal(), userProfile.getEmail(), user.getId());

        return "redirect:/profile";
    }

/*    @RequestMapping ("/updateConfirmation")
    public String displayUpdateConfirmation () {
        return "updateConfirmation";
    }*/

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public String viewProfile(ModelMap modelMap, HttpSession session) {
        User user = (User) session.getAttribute("user");
        UserProfile userProfile = editProfileDao.displayProfileByUserId(user.getId());
        modelMap.put("profile", userProfile);
        return "displayProfile";
    }

    @RequestMapping(path = "/profile/image", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getProfileImage(@RequestParam("id") Long id) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        BufferedImage img;
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        byte[] media = editProfileDao.getProfileImage(id);
        if (media == null) {
            media = FileUtils.readFileToByteArray(ResourceUtils.getFile("classpath:../../img/150.png"));
        }
        return new ResponseEntity<>(media, headers, HttpStatus.OK);
    }


}
