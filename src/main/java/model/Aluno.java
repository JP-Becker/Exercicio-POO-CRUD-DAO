package model;

import dao.AlunoDAO;
import java.util.ArrayList;


public class Aluno extends Pessoa {

    private String curso;
    private int fase;

    public Aluno() {
        this("",0,0,"", 0);
    }

   

    public Aluno(String curso, int fase, int id, String nome, int idade) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }
// Override necessário para poder retornar os dados de Pessoa no toString para aluno.

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Curso: " + this.getCurso()
                + "\n Fase:" + this.getFase()
                + "\n -----------";
    }
    
    public ArrayList getMinhaLista() {
        return AlunoDAO.getMinhaLista();
    }

    
    public boolean InsertAlunoBD(Aluno objeto) {
        AlunoDAO.getMinhaLista().add(objeto);
        return true;
    }
    
    public boolean DeleteAlunoBD(int id) {
        int indice = this.procuraIndice(id);
        AlunoDAO.getMinhaLista().remove(indice);
        return true;
     }
    
    public boolean UpdateAlunoBD(int id, Aluno objeto) {
        int indice = this.procuraIndice(id);
        AlunoDAO.getMinhaLista().set(indice, objeto);
        return true;
     }

    public int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AlunoDAO.getMinhaLista().size(); i++) {
            if (AlunoDAO.getMinhaLista().get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

}
