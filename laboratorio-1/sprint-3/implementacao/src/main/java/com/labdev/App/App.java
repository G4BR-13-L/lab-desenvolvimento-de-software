package com.labdev.App;

public class App {
    public void iniciar() {
        var menuGlobal = MenuGlobal.getInstance();
        menuGlobal.iniciar();
    }

    public static void main(String[] args) {
        var app = new App();
        app.iniciar();
    }
}
