package controller;

import java.util.Scanner;

/**
 * Classe que implementa a cifra de César para criptografia e descriptografia de textos.
 */
public class CesarCipher {

    /**
     * Inicia o processo de criptografia ou descriptografia com interação do usuário.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        char choice;
        boolean continuar = true;

        while (continuar) {
            while (true) {
                System.out.print("Você deseja criptografar ou descriptografar? (C/D): ");
                choice = scanner.next().charAt(0);
                if (choice == 'C' || choice == 'c' || choice == 'D' || choice == 'd') {
                    break;
                } else {
                    System.out.println("Escolha inválida. Por favor, selecione 'C' para criptografar ou 'D' para descriptografar.");
                }
            }

            System.out.print("Palavra a ser processada: ");
            scanner.nextLine();  // Consumir a nova linha
            String word = scanner.nextLine();

            int shift = 0;
            while (true) {
                try {
                    System.out.print("Chave de deslocamento: ");
                    shift = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                }
            }

            if (choice == 'C' || choice == 'c') {
                System.out.println("Palavra criptografada: " + encrypt(word, shift));
            } else if (choice == 'D' || choice == 'd') {
                System.out.println("Palavra descriptografada: " + decrypt(word, shift));
            }

            System.out.print("Você deseja realizar outra operação? (S/N): ");
            char continuarChoice = scanner.next().charAt(0);
            if (continuarChoice == 'N' || continuarChoice == 'n') {
                continuar = false;
            }
        }

        scanner.close();
    }

    /**
     * Criptografa o texto usando a cifra de César.
     * 
     * @param text O texto a ser criptografado.
     * @param shift A chave de deslocamento.
     * @return O texto criptografado.
     */
    private String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            if (Character.isUpperCase(charAt)) {
                char ch = (char)(((int)charAt + shift - 65) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(charAt)) {
                char ch = (char)(((int)charAt + shift - 97) % 26 + 97);
                result.append(ch);
            } else {
                result.append(charAt);
            }
        }
        return result.toString();
    }

    /**
     * Descriptografa o texto usando a cifra de César.
     * 
     * @param text O texto a ser descriptografado.
     * @param shift A chave de deslocamento.
     * @return O texto descriptografado.
     */
    private String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }
}
