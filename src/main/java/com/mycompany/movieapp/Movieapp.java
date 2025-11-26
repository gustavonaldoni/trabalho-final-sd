package com.mycompany.movieapp;

public class Movieapp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new MovieWindow().setVisible(true));
    }
}
