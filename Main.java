import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

public class Main{

    public static void VerifSenha(String usertype, String linha) {
       
        String senha = linha.substring(12);
        System.out.print("Digite sua senha: ");
        Scanner input = new Scanner(System.in);
        String senhadigitada = input.nextLine();

        if(senhadigitada.equals(senha)){
            System.out.println("Senha válida!");
            Menu.menuOperacoes(usertype);
        }
        else{
            System.out.println("Senha invalida");
            Controle(usertype);
        }

        
    }


    public static void Controle(String usertype){
        
        try {
            File senhas = new File(usertype);
            Scanner scan = new Scanner(senhas);
            String currentLine, senha, cpf;
            
            System.out.print("Digite seu CPF: ");
            Scanner input = new Scanner(System.in);
            cpf = input.nextLine();
            
            String compare;
            while((currentLine = scan.nextLine()) != null){
                compare = currentLine.substring(0,11);
                
                if (compare.equals(cpf)) {
                    break;
                }
                else{
                    if (!(scan.hasNextLine())) {
                        System.out.println("CPF invalido!");
                        Menu();
                    }
                }
            }
            VerifSenha(usertype, currentLine);

        } catch (Exception e) {
            //TODO: handle exception
        }
    }





    public static void Menu(){
        
        System.out.print("Escolha uma das opções seguintes:\n1 - Acessar o sistema como Administrador\n2 - Acessar o sistema como Professor\n3 - Acessar o sistema como Aluno\n4 - Sair\nOpção: ");
        Scanner input = new Scanner(System.in);
        int escolha = input.nextInt();
        
        if(escolha == 1){
            Controle("admin.txt");
        }
        else if(escolha == 2){
            Controle("prof.txt");
        }
        else if(escolha == 3){
            Controle("aluno.txt");
        }
        
        else if(escolha == 4){
            return;
        }

        else{
            System.out.print("Você digitou uma opção inválida.\n");
            Menu();
        }   

    }
    
    public static void main(String[] args) {
      Menu();
        
    }
}


