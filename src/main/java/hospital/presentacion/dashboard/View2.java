package hospital.presentacion.dashboard;

import com.github.lgooddatepicker.components.DatePicker;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class View2 {
    private JPanel dashboard_JPanel;
    private JPanel Datos_JPanel;
    private JPanel Medicamentos_JPanel;
    private JPanel Recetas_JPanel;

    public JPanel getDashboard_JPanel() { return dashboard_JPanel; }

    private void createUIComponents() {
        // Panel principal con GridBagLayout
        dashboard_JPanel = new JPanel(new GridBagLayout());
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.insets = new Insets(5, 5, 5, 5); // margen general
        mainGbc.fill = GridBagConstraints.BOTH;
        mainGbc.weightx = 1.0;
        mainGbc.weighty = 1.0;

        // -----------------------------
        // GRÁFICO DE RECETAS (Pie Chart)
        // -----------------------------
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("PROCESO", 4);
        pieDataset.setValue("LISTA", 4);
        pieDataset.setValue("ENTREGADA", 3);
        pieDataset.setValue("CONFECCIONADA", 3);

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Recetas", pieDataset, true, true, false
        );
        LegendTitle legend = pieChart.getLegend();
        if (legend != null) {
            legend.setFrame(new BlockBorder(Color.BLACK));
            legend.setBackgroundPaint(Color.WHITE);
            legend.setMargin(new RectangleInsets(0, 0, 0, 0));
        }
        Recetas_JPanel = new ChartPanel(pieChart);

        // -----------------------------
        // GRÁFICO DE MEDICAMENTOS (Line Chart)
        // -----------------------------
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(45, "Acetaminofén", "2025-08");
        dataset.addValue(40, "Acetaminofén", "2025-09");
        dataset.addValue(45, "Acetaminofén", "2025-10");

        dataset.addValue(23, "Amoxicilina", "2025-08");
        dataset.addValue(30, "Amoxicilina", "2025-09");
        dataset.addValue(25, "Amoxicilina", "2025-10");

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Medicamentos", "Mes", "Cantidad", dataset
        );
        LegendTitle legendLines = lineChart.getLegend();
        if (legendLines != null) {
            legendLines.setFrame(new BlockBorder(Color.BLACK));
            legendLines.setBackgroundPaint(Color.WHITE);
            legendLines.setMargin(new RectangleInsets(0, 0, 0, 0));
        }
        CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        for (int i = 0; i < dataset.getRowCount(); i++) {
            renderer.setSeriesLinesVisible(i, true);
            renderer.setSeriesShapesVisible(i, true);
        }
        renderer.setDefaultShape(new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6));
        plot.setRenderer(renderer);
        Medicamentos_JPanel = new ChartPanel(lineChart);

        // -----------------------------
        // PANEL DE DATOS
        // -----------------------------
        Datos_JPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1.0; // Para que los campos se expandan horizontalmente

        int row = 0;

        // Desde
        gbc.gridx = 0; gbc.gridy = row;
        Datos_JPanel.add(new JLabel("Desde:"), gbc);

        gbc.gridx = 1;
        Datos_JPanel.add(new DatePicker(), gbc);

        row++;
        // Hasta
        gbc.gridx = 0; gbc.gridy = row;
        Datos_JPanel.add(new JLabel("Hasta:"), gbc);

        gbc.gridx = 1;
        Datos_JPanel.add(new DatePicker(), gbc);

        row++;
        // Medicamentos
        gbc.gridx = 0; gbc.gridy = row;
        Datos_JPanel.add(new JLabel("Medicamentos:"), gbc);

        gbc.gridx = 1;
        Datos_JPanel.add(new JComboBox<>(new String[]{"Acetaminofén", "Amoxicilina", "Ibuprofeno"}), gbc);

        ;
        // Botones
        gbc.gridx = 2; gbc.gridy = row; gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.add(new JButton("✔"));
        panelBotones.add(new JButton("✖"));
        Datos_JPanel.add(panelBotones, gbc);
        gbc.gridwidth = 1;

        row++;
        // Tabla
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.BOTH;
        JTable tabla = new JTable(
                new Object[][]{
                        {"Acetaminofén", 45, 40, 45},
                        {"Amoxicilina", 23, 30, 25}
                },
                new String[]{"Medicamento", "2025-08", "2025-09", "2025-10"}
        );
        JScrollPane scrollTabla = new JScrollPane(tabla);
        Datos_JPanel.add(scrollTabla, gbc);

        // -----------------------------
        // AGREGAR TODO AL DASHBOARD
        // -----------------------------
        // Datos (izquierda)

        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        mainGbc.weightx = 0.3;
        mainGbc.weighty = 1.0;
        dashboard_JPanel.add(Datos_JPanel, mainGbc);

        // Medicamentos (centro)
        mainGbc.gridx = 1;
        mainGbc.weightx = 0.35;
        dashboard_JPanel.add(Medicamentos_JPanel, mainGbc);

        // Recetas (derecha)
        mainGbc.gridx = 2;
        mainGbc.weightx = 0.35;
        dashboard_JPanel.add(Recetas_JPanel, mainGbc);
    }
}
