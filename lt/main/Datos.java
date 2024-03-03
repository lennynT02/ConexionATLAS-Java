import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;

import com.mongodb.client.*;
import org.bson.Document;

public class Datos {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    JLabel nom = new JLabel("Nombre");
    JLabel pasatiempo = new JLabel("Pasatiempo");
    JLabel descripcion = new JLabel("Descripcion");

    JTextField nombre = new JTextField(20);
    JTextField pasatiempos = new JTextField(20);
    JTextField descripciones = new JTextField(20);

    JButton guardar = new JButton("Guardar");

    public Datos() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nom, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nombre, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(pasatiempo, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(pasatiempos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(descripcion, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(descripciones, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(guardar, gbc);

        guardar.addActionListener(e -> {
            try {
                MongoClient mongoClient = MongoClients.create(
                        "mongodb+srv://esfot:esfot2024@cluster0.xzffuex.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
                MongoDatabase database = mongoClient.getDatabase("DeberPoo");
                MongoCollection<Document> collection = database.getCollection("Pasatiempos");
                Document document = new Document("nombre", nombre.getText())
                        .append("pasatiempo", pasatiempos.getText())
                        .append("descripcion", descripciones.getText());
                collection.insertOne(document);
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            } catch (Exception ex) {
                System.out.println("Error. La conexion esta deshabilitada " + ex);
            }
        });
    }
}
