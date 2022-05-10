package com.thiagopaes.engenharia.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Util {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Toma o texto de pedida da entrada como par�metro. Verifica se a entrada � um
	 * inteiro v�lido e devolve o inteiro caso verdadeiro, caso contr�rio imprime
	 * "Entrada inv�lida" e repete a fun��o.
	 */
	public static int validaInt(String text) {
		String input;
		System.out.printf(text);
		try {
			input = scanner.nextLine();
			return Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Entrada inv�lida!");
			return validaInt(text);
		}
	}

	/**
	 * Toma o texto de pedida da entrada como par�metro. Verifica se a entrada � um
	 * num�rico v�lido e devolve o double caso verdadeiro, caso contr�rio imprime
	 * "Entrada inv�lida" e repete a fun��o.
	 */
	public static double validaDouble(String text) {
		String input;
		System.out.printf(text);
		try {
			input = scanner.nextLine();
			return Double.parseDouble(input);
		} catch (Exception e) {
			System.out.println("Entrada inv�lida!");
			return validaDouble(text);
		}
	}

	/**
	 * Toma o texto de pedida da entrada como par�metro. Verifica se a entrada � um
	 * inteiro v�lido e est� no range de Byte, devolve o byte caso verdadeiro, caso
	 * contr�rio imprime "Entrada inv�lida" e repete a fun��o.
	 */
	public static byte validaByte(String text) {
		String input;
		System.out.printf(text);
		try {
			input = scanner.nextLine();
			return Byte.parseByte(input);
		} catch (Exception e) {
			System.out.println("Entrada inv�lida!");
			return validaByte(text);
		}
	}

	/**
	 * Recebe um inteiro x e aguarda x milissegundos.
	 */
	public static void delay(int mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Usa a classe Robot para pressionar ALT+SHIFT+Q e depois C para focalizar
	 * console. Em seguida, pressiona SHIFT+F10 e depois R para apagar o console.
	 * Funciona somente para o Eclipse.
	 */
	public static void limpa() {
		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ALT);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_Q);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_Q);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_C);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_C);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_F10);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_F10);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_R);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_R);
			robot.delay(100);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void printLine() {
		System.out.println("---------------------------------------------------------------------");
	}

	/**
	 * Pula uma linha. (cr�ditos para o Vinicios)
	 */
	public static void br() {
		System.out.println("");
	}

}
