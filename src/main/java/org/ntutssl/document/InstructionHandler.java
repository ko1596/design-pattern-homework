package org.ntutssl.document;

import java.util.Iterator;
import java.util.Scanner;

public class InstructionHandler {

	private Editor editor;
	private Scanner input;

	public InstructionHandler(Editor editor) {
		this.editor = editor;
		this.input = new Scanner(System.in);
	}

	public void run() {
		do printEditorInstructions();
		while(handleEditorInstructions(input.nextLine()));
		input.close();		
	}

	private void printEditorInstructions() {
		System.out.println("Please enter the following instruction to start editing:");
		System.out.println(" 1. 'add title': to add a title to the editor");
		System.out.println(" 2. 'add paragraph': to add a paragraph to the editor");
		System.out.println(" 3. 'add article': to add an article to the editor");
		System.out.println(" 4. 'find content': to find the specific string in the editor");
		System.out.println(" 5. 'output html': to transfer the text to html format");
		System.out.println(" 6. 'exit': to exit the program");
	}
	
	private boolean handleEditorInstructions(String instruction) {
		if(instruction.equals("add title")) {
			try {
				this.editor.add(addTitleInstruction());
				System.out.println("Title added to the editor.");
			} catch (Exception e) {
				System.out.println("Invalid input: Must be between 0~6");
			}			

		}else if(instruction.equals("add paragraph")) {
			this.editor.add(addParagraphInstruction());
			System.out.println("Paragraph added to the editor.");

		}else if(instruction.equals("add article")){
			try {
				Article art = (Article) addArticleInstruction(0);
				if(art == null) return true;
				do{
					printArticleInstructions();
				}while(handleArticleInstructions(input.nextLine(), art));

				editor.add(art);
				System.out.println("Article added to the article.");
			} catch (Exception e) {
				System.out.println("Invalid input: LEVEL must be a positive integer");
			}

		}else if(instruction.equals("find content")){
			this.findContentInstruction();

		}else if(instruction.equals("output html")){
			this.outputHtmlInstruction();

		}else if(instruction.equals("exit")){
			return false;
		}
		else{
			System.out.println("Invalid instruction");
			return true;
		}
		return true;
	}

	private Document addTitleInstruction() {
		System.out.println("Please enter the information of title: ");
		System.out.print("Text of title: ");
		String title = input.nextLine();
		System.out.print("Size of title: ");
		int size = input.nextInt();
		input.nextLine();
		return new Title(title, size);
	}

	private Document addParagraphInstruction() {
		System.out.println("Please enter the information of paragraph: ");
		System.out.print("Text of paragraph: ");
		return new Paragraph(input.nextLine());
	}

	private Document addArticleInstruction(int lastLevel) {
		System.out.println("Please enter the information of article: ");
		System.out.print("Topic of article: ");
		String topic = input.nextLine();
		System.out.print("Level of article: ");
		int level = input.nextInt();
		input.nextLine();
		if(level < 0 || level < lastLevel) {
			System.out.println("Invalid Input: The level should be positive or higher than the level of the current article");
			return null;
		}
		Article article = new Article(topic, level);
		while(true){
			printArticleInstructions();
			String instruction = input.nextLine();
			if(!instruction.equals("exit")) handleArticleInstructions(instruction, article);
			else break;
		}
		return article;
	}

	private void printArticleInstructions() {
		System.out.println("Please enter the following instruction to edit the article: ");
		System.out.println(" 1. 'add title': to add a title to the article");
		System.out.println(" 2. 'add paragraph': to add a paragraph to the article");
		System.out.println(" 3. 'add article': to add an article to the article");
		System.out.println(" 4. 'exit': to exit the process");
	}

	private boolean handleArticleInstructions(String instruction, Article article) {
		if(instruction.equals("add article")) {
			article.add(addArticleInstruction(article.getLevel()));
			System.out.println("Article added to the article.");
		}else if(instruction.equals("add paragraph")) {
			article.add(addParagraphInstruction());
			System.out.println("Paragraph added to the article.");
		}else if(instruction.equals("add title")) {
			article.add(addTitleInstruction());
			System.out.println("Title added to the article.");
		}else{
			System.out.println("Invalid instruction");
			return true;
		}
		return false;
	}

	private void findContentInstruction() {
		System.out.print("Enter the word you want to find: ");
		String target = input.nextLine();
		FindContentVisitor fcv = new FindContentVisitor(target);
		Iterator<Document> it = this.editor.iterator();
		while(it.hasNext()) it.next().accept(fcv);
		for (Document i : fcv.getResult()) System.out.println(i.toString());
	}

	private void outputHtmlInstruction() {
		HtmlOutputVisitor hov = new HtmlOutputVisitor();
		Iterator<Document> it = this.editor.iterator();
		while(it.hasNext()) it.next().accept(hov);
		System.out.println(hov.getResult());
	}
}