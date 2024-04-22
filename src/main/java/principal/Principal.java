package principal;
import model.Aluno;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
       Aluno objetoAluno = new Aluno();
       int opcao = 0;
       while (opcao != 9) {
           opcao = Integer.parseInt(JOptionPane.showInputDialog(""
                   + "1 - Criar\n"
                   + "2- Ler\n"
                   + "3 - Atualizar\n"
                   + "4 - Deletar\n"
                   + "5 - Listar todos\n"
                   + "9 - Cancelar\n"));
        switch (opcao) {
            case 1:
                Aluno novo = new Aluno();
                novo.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite a ID:")));
                novo.setNome(JOptionPane.showInputDialog("Digite o Nome:"));
                novo.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")));
                novo.setCurso(JOptionPane.showInputDialog("Digite o Curso:"));
                novo.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a Fase:")));
                
                objetoAluno.InsertAlunoBD(novo);
                System.out.println("Aluno criado!");
            break;
            case 2:
            // ler;
                int idConsultar = Integer.parseInt(JOptionPane.showInputDialog("Digite a ID do aluno a ser excluido:"));
                int posicaoConsulta = objetoAluno.procuraIndice(idConsultar);
  
                    if (posicaoConsulta == -1) {
                        System.out.println("ID nao existe");
                    } else {
                        System.out.println("Aluno encontrado!!");
                        System.out.println("ID: " + objetoAluno.getMinhaLista().get(posicaoConsulta).getId());
                        System.out.println("Nome: " + objetoAluno.getMinhaLista().get(posicaoConsulta).getNome());
                        System.out.println("Idade: " + objetoAluno.getMinhaLista().get(posicaoConsulta).getIdade());
                        System.out.println("Curso: " + objetoAluno.getMinhaLista().get(posicaoConsulta).getCurso());
                        System.out.println("Fase: " + objetoAluno.getMinhaLista().get(posicaoConsulta).getFase());
                    }
                
            break;
            case 3:
                
                int idAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite a ID do aluno a ser excluido:"));
                int posicaoAtualizar = objetoAluno.procuraIndice(idAtualizar);
                
                Aluno aluno = new Aluno();
                
                if (posicaoAtualizar == -1) {
                        System.out.println("ID nao existe");
                    } else {
                        System.out.println("Aluno encontrado!!");
                        aluno.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite a ID")));
                        aluno.setNome(JOptionPane.showInputDialog("Digite o nome"));
                        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a Idade")));
                        aluno.setCurso(JOptionPane.showInputDialog("Digite o curso"));
                        aluno.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase")));
                        System.out.println("Aluno de id" + idAtualizar + " alterado");
                    }
                }
           
            break;
            case 4:
            // delete;
                int idExcluir = Integer.parseInt(JOptionPane.showInputDialog("Digite a ID do aluno a ser excluido:"));
                int posicaoExcluir = objetoAluno.procuraIndice(idExcluir);;
               
                    
                    if (posicaoExcluir == -1) {
                        System.out.println("ID nao existe");
                    } else {
                        System.out.println("Aluno encontrado!!");
                        objetoAluno.getMinhaLista().remove(posicaoExcluir);
                    }
                
            break;
            case 5:
                for (int i=0;i < objetoAluno.getMinhaLista().size();i++) {
                    System.out.println("ID:" + objetoAluno.getMinhaLista().get(i).getId());
                    System.out.println("Nome:" + objetoAluno.getMinhaLista().get(i).getNome());
                    System.out.println("Idade:" + objetoAluno.getMinhaLista().get(i).getIdade());
                    System.out.println("Curso:" + objetoAluno.getMinhaLista().get(i).getCurso());
                    System.out.println("Fase:" + objetoAluno.getMinhaLista().get(i).getFase());
                }
                break;
            case 9:
                System.out.println("Operação cancelada");;
            break;
            default:
                System.out.println("Erro!");
                break;
        }}
    } 
}
