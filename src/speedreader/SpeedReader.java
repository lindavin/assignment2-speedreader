package speedreader;

import java.awt.Graphics;
import java.awt.Font;

public class SpeedReader {

	public void demonstratePanel() {
		DrawingPanel panel = new DrawingPanel(400, 300);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, 46);
		g.setFont(f);
		g.drawString("Hello World!", 100, 100);
	}

	public void printStaggered() throws InterruptedException {
		while (true) {
			System.out.println("Hello World!");
			Thread.sleep(1000);
		} // while
	} // printStaggered

	/*
	 * Usage: SpeedReader <filename> <width> <height> <font size> <wpm>
	 */

	public static void main(String[] args) throws Exception {

		// checks for the correct number of arguments
		if (args.length != 5) {
			System.err.println("Incorrect number of arguments");
			System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
			System.exit(1);
		}

		WordGenerator wg = new WordGenerator(args[0]);
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		int fontSize = Integer.parseInt(args[3]);
		int wpm = Integer.parseInt(args[4]);

		// creating panel
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontSize);
		g.setFont(f);

		while (wg.hasNext()) {
			g.drawString("Hello World!", 100, 100);
			Thread.sleep((long) (1.0/wpm * 60000));
		} // while

	} // main(String[])

} // Class SpeedReader
