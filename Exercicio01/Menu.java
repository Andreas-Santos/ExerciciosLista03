import java.util.ArrayList;
import java.util.Scanner;

//autor: Andreas Matheus Santos - RA: 235006

public class Menu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int escolha;
        ArrayList<Curso> cursos = new ArrayList<Curso>();

        do{
            System.out.println("Menu:");
            System.out.println("-------------");
            System.out.println("1 - Criar Curso");
            System.out.println("2 - Criar Aluno");
            System.out.println("3 - Remover Aluno");
            System.out.println("4 - Mostrar todos os cursos");
            System.out.println("5 - Mostrar alunos dos cursos");
            System.out.println("6 - Sair");
            escolha = Integer.parseInt(teclado.next());

            switch(escolha){
                case 1:
                    int codigo;
                    String nome;
                    int cargaHoraria;

                    System.out.println("Digite o código do curso:");
                    codigo = Integer.parseInt(teclado.next());

                    teclado.nextLine();

                    System.out.println("Digite o nome do curso:");
                    nome = teclado.nextLine();

                    System.out.println("Digite a carga horária do curso:");
                    cargaHoraria = Integer.parseInt(teclado.next());

                    Curso c = new Curso(codigo, nome, cargaHoraria); // cria o curso
                    cursos.add(c); // adiciona o curso a lista de cursos
                    break;

                case 2:
                    Aluno a = new Aluno(); //cria aluno

                    teclado.nextLine();

                    System.out.println("Digite o RA");
                    a.setRa(teclado.nextLine());

                    System.out.println("Digite o nome");
                    a.setNome(teclado.nextLine());

                    int cursoEscolhido;
                    System.out.println("Escolha o curso");
                    for(int i = 0; i < cursos.size(); i++){
                        int x = i + 1;
                        System.out.println(x + " - " + cursos.get(i).getNome());
                    }
                    cursoEscolhido = Integer.parseInt(teclado.nextLine()) - 1;

                    cursos.get(cursoEscolhido).setAluno(a); // adiciona aluno ao curso
                    break;

                case 3:
                    teclado.nextLine();

                    System.out.println("Digite o RA do aluno");
                    String raAluno = teclado.nextLine();

                    // verifica em todos os cursos se existe um aluno com esse RA
                    for (Curso curso : cursos){
                        for (int i = 0; i < curso.getAlunos().size(); i++){
                            if(raAluno.equals(curso.getAlunos().get(i).getRa())){
                                curso.removerAluno(i); // deleta o aluno que possuí esse RA
                            }
                        }
                    } 
                    break;

                case 4:
                    // imprime os dados de todos os cursos
                    for(Curso curso : cursos){
                        System.out.println(curso.imprimir());
                    }
                    break;

                case 5:
                    //imprime os dados completos de todos os cursos (com alunos)
                    for(Curso curso : cursos){
                        System.out.println(curso.imprimirCompleto());
                    }
                    break;

                case 6:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("O número digitado não é válido!");
                    break;
            }
        }while(escolha != 6);

        teclado.close();
    }
}