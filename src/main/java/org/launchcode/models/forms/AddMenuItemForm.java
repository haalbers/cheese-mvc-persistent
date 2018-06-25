package org.launchcode.models.forms;

import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {
    private Menu menu;
    public Menu getMenu() {
        return menu;
    }

    private Iterable<Cheese> cheeses;
    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

    @NotNull
    private int menuId;
    public int getMenuId() {
        return menuId;
    }

    @NotNull
    private int cheeseId;
    public int getCheeseId() {
        return cheeseId;
    }

    public AddMenuItemForm() {
    }

    public AddMenuItemForm(Menu menu, Iterable<Cheese> cheeses) {
        this.menu = menu;
        this.cheeses = cheeses;
    }
}
