package com.mycompany.movieapp;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class MovieWindow extends JFrame {

    private final MovieService service = new MovieService();
    private final JPanel listPanel = new JPanel();

    public MovieWindow() {
        super("IMDb - Top 10 Filmes Populares");
        configure();
        loadMovies();
    }

    private void configure() {
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listPanel.setLayout(new GridLayout(0, 1, 10, 10));
        JScrollPane pane = new JScrollPane(listPanel);
        pane.setBorder(BorderFactory.createTitledBorder("Top 10 IMDb"));
        add(pane, BorderLayout.CENTER);
    }

    private void loadMovies() {
        new Thread(() -> {
            try {
                List<Movie> movies = service.fetchTop100();
                for (Movie m : movies) {
                    listPanel.add(createMovieCard(m));
                }
            } catch (Exception e) {
                listPanel.add(new JLabel(e.getMessage()));

            }
            listPanel.revalidate();
        }).start();
    }

    private JPanel createMovieCard(Movie m) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        card.setBackground(Color.WHITE);

        try {
            ImageIcon icon = new ImageIcon(new URL(m.getImageUrl()));
            Image img = icon.getImage().getScaledInstance(90, 130, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(img));
            card.add(imgLabel, BorderLayout.WEST);
        } catch (Exception e) {
            card.add(new JLabel("Sem imagem"), BorderLayout.WEST);
        }

        JTextArea text = new JTextArea(
                m.getTitle() + " (" + m.getYear() + ")\n"
                + "Rating: " + m.getRating() + "\n"
                + "Description: " + m.getDescription()
        );
        text.setEditable(false);
        text.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        text.setBackground(Color.WHITE);
        card.add(text, BorderLayout.CENTER);

        return card;
    }
}
