package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.example.controllers.TecnicoController;
import com.example.models.Tecnicos;

public class TecnicosPanel extends JPanel {
    private TecnicoController tecnicoController;
    private JTable tecnicosTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarTecnico;

    public TecnicosPanel() {
        super(new BorderLayout());
        tecnicoController = new TecnicoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);
        tecnicosTable = new JTable(tableModel);

        // Criar a tabela
        List<Tecnicos> tecnicos = tecnicoController.readTecnicos();
        for (Tecnicos tecnico : tecnicos) {
            tableModel.addRow(new Object[] {
                tecnico.getId(),
                tecnico.getNome(),
                tecnico.getEspecialidade(),
                tecnico.getDisponibilidade()
            });
        }

        JScrollPane scrollPane = new JScrollPane(tecnicosTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões
    }
}
