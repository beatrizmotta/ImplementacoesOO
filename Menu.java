import Domain.Aluno;
import Domain.User;

import java.util.Scanner;


public class Menu {
    
    public static void menuOperacoes(String usertype){
        
        //falta menu de varias operações
        if(usertype.equals("admin.txt")){
            User usuario = new User();
            System.out.print("Selecione o tipo de usuario que você quer inserir\n1 - Professor\n2 - Domain.Aluno\n");
            Scanner input = new Scanner(System.in);
            int escolha = input.nextInt();
            if (escolha == 1){
//                usuario = (Professor) usuario;
            }
            else if (escolha == 2){
                usuario = (Aluno) usuario;
            }
            else{
                System.out.print("Opção invalida");
                menuOperacoes(usertype);
            }
//            UsuarioCreator.init(usuario);
        }
        else{
            System.out.print("Você não tem permissão para realizar essa ação");
            Main.Menu();
        }
        


    }
}
