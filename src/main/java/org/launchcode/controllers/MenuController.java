package org.launchcode.controllers;

import org.launchcode.models.Menu;
import org.launchcode.models.data.MenuDao;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.Cheese;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.forms.AddMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;
    private Menu menu;

    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "Menus");

        return "menu/index";
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int id) {
        model.addAttribute("menu", menuDao.findOne(id));
        return "menu/view" + id;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMenuForm(Model model){

        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());

        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMenuForm(@ModelAttribute @Valid Menu newMenu,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "menu/add";
        }

        menuDao.save(newMenu);
        menu = newMenu;
        return "redirect:view/" + menu.getId();
    }

    @RequestMapping(value = "add-item", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int id) {

        menu = menuDao.findOne(id);
        cheeses = menu.getCheeses();
        AddMenuItemForm form = AddMenuItemForm(menu, cheeses);
        model.addAttribute("form", form);
        model.addAttribute("title", "Add item to menu:" + menu);

        return "menu/add-item";
    }
}
