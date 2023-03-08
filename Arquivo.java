import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner; // Import the Scanner class to read text files


public class Arquivo {
    public static void createFileTurma(final Turma turma) {
        final String file_name = turma.getNome();
        try {
            final FileWriter texto = new FileWriter(file_name + ".txt");
            texto.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAlunoToTurma(final Turma turma, final Aluno aluno) {
        final String nomeTurma = turma.getNome();
        try {

            // Checa se já existe um arquivo para turma e cria caso não
            final File fileTurma = new File(nomeTurma + ".txt");
            if(!fileTurma.exists() && !fileTurma.isDirectory()) { 
                createFileTurma(turma);
                Files.write(Paths.get(nomeTurma + ".txt"), (Integer.toString(aluno.getNumeroDeMatricula()) + " " + aluno.getNome() + "\n").getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(nomeTurma + ".txt"), (Integer.toString(aluno.getNumeroDeMatricula()) + " " + aluno.getNome() + "\n").getBytes(), StandardOpenOption.APPEND);
            }

        }catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFileAluno(final Aluno aluno) {
        // String file_name = Integer.toString(aluno.numeroDeMatricula) + "_" + aluno.nome;
        final String file_name = Integer.toString(aluno.numeroDeMatricula);
        final String file_content = AlunoCreator.getAlunoInfoAsString(aluno);

        try {
            final FileWriter texto = new FileWriter(file_name);
            texto.write(file_content);
            texto.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }


    public static void addNumeroMatriculaAluno(final Aluno aluno) {
        try {
            Files.write(Paths.get("matriculas.txt"), (Integer.toString(aluno.getNumeroDeMatricula()) + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAlunoNomeTurmaFromFile(final int numeroDeMatricula) {

        final String numeroDeMatriculaString = Integer.toString(numeroDeMatricula);

        String serie = "", ensino = "", turno = ""; 
        try {
            final File alunoFile = new File(numeroDeMatriculaString);
            final BufferedReader reader = new BufferedReader(new FileReader(alunoFile));
            
            String currentLine; 

            int counter = 0; 
            
            while((currentLine = reader.readLine()) != null) {
                if (counter == 5){
                    serie = String.valueOf((currentLine.substring(0, 0) + currentLine.substring(7)).charAt(0));
                }
                if (counter == 6){
                    ensino = String.valueOf((currentLine.substring(0, 0) + currentLine.substring(16)).charAt(0));
                }
                if (counter == 7) {
                    turno = String.valueOf((currentLine.substring(0, 0) + currentLine.substring(7)).charAt(0));
                    break;
                }
                counter++; 
            }


        } catch (final IOException e) {
            System.out.println("Não existe aluno com esse número de matrícula!");
        }

        return serie + ensino + turno;
    }

    public static String getAlunoInfoFromFile(final String numeroDeMatricula) {
        
        try {
            final File alunoFile = new File(numeroDeMatricula);
            final BufferedReader reader = new BufferedReader(new FileReader(alunoFile));
            
            String currentLine; 

            int counter = 0; 
            final String aux = "";
            while((currentLine = reader.readLine()) != null) {

                if(counter > 10){
                    break;
                }
                
                System.out.println(currentLine);
                counter++; 
            }


        } catch (final IOException e) {
            System.out.println("Não existe aluno com esse número de matrícula!");
        }


        return "A";
    }

    public static void mostrarAlunosTurma(final String nomeArquivoTurma) {
        try {
            final File alunoFile = new File(nomeArquivoTurma + ".txt");
            final BufferedReader reader = new BufferedReader(new FileReader(alunoFile));
            
            String currentLine;

            while((currentLine = reader.readLine()) != null) {

                System.out.println(currentLine);
                
            }


        } catch (final IOException e) {
            System.out.println("Não existe turma com esse nome!");
        }



    }


    public static void removeNumeroMatricula(final int numeroDeMatricula, final String nomeDaTurma, final boolean expelled) {
        final String numeroDeMatriculaString = Integer.toString(numeroDeMatricula);
        final Scanner Input = new Scanner(System.in);
        

        File inputFile = new File("matriculas.txt");
        File tempFile = new File("matriculasTemp.txt");
        // File matriculaFileNew = expelled ? new File(numeroDeMatriculaString + "_expelled") : new File(numeroDeMatriculaString + "_inactive");
        if(expelled == true){
            final File matriculaFile = new File(numeroDeMatriculaString);
            matriculaFile.renameTo(new File(numeroDeMatriculaString + "_expelled"));
        }else{
            final File matriculaFile = new File(numeroDeMatriculaString);
            matriculaFile.renameTo(new File(numeroDeMatriculaString + "_inactive"));
        }

        
        try {

            final BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            final BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    
            final String lineToRemove = numeroDeMatriculaString;
            String currentLine;
    
            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                final String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 

            inputFile.delete();
            final boolean successful = tempFile.renameTo(inputFile);



        } catch (final IOException e) {
            e.printStackTrace();
        }

        // Removendo do arquivo da turma
        inputFile = new File(nomeDaTurma + ".txt");
        tempFile = new File(nomeDaTurma + "Temp.txt");

        try {

            final BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            final BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    
            final String lineToRemove = numeroDeMatriculaString;
            String currentLine;
    
            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                final String trimmedLine = currentLine.trim();
                if(trimmedLine.startsWith(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 

            inputFile.delete();
            final boolean successful = tempFile.renameTo(inputFile);

        } catch (final IOException e) {
            e.printStackTrace();
        }
        
    }
}