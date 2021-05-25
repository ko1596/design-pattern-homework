package org.ntutssl.document;

import java.util.Scanner;

public class InstructionHandler {

	private Editor editor;
	private Scanner input;
	private CommandManager commandManager;

	public InstructionHandler(Editor editor) {
		this.editor = editor;
		this.input = new Scanner(System.in);
		this.commandManager = new CommandManager();
	}

	public void run() {
		do printEditorInstructions();
		while(handleEditorInstructions(input.nextLine()));
		input.close();		
	}

	private void printEditorInstructions() {
		System.out.println("Please enter the following instruction to start editing:");
		System.out.println("  1. 'add title': to add a title to the editor");
		System.out.println("  2. 'add paragraph': to add a paragraph to the editor");
		System.out.println("  3. 'add article': to add an article to the editor");
		System.out.println("  4. 'find content': to find the specific string in the editor");
		System.out.println("  5. 'import json': to import Document into editor from json file");
		System.out.println("  6. 'output html': to transfer the text to html format");
		System.out.println("  7. 'undo': to undo the previous 'add' instruction in the editor");
		System.out.println("  8. 'redo': to redo the previous undo instruction in the editor");
		System.out.println("  9. 'exit': to exit the program");
	}
	
	private boolean handleEditorInstructions(String instruction) {
		if(instruction.equals("add title")) {
			try {
				commandManager.executeCmd(new AddCommandToEditor(editor, addTitleInstruction()));
				System.out.println("Title added to the editor.");
			} catch (Exception e) {
				System.out.println("Invalid Input: The size should be in range 1 to 6");
			}			

		}else if(instruction.equals("add paragraph")) {
			commandManager.executeCmd(new AddCommandToEditor(editor, addParagraphInstruction()));
			System.out.println("Paragraph added to the editor.");

		}else if(instruction.equals("add article")){
			try {
				CommandManager articleCommandManager = new CommandManager();
				Article art = (Article) addArticleInstruction(0);
				if(art == null) return true;
				do{
					printArticleInstructions();
				}while(handleArticleInstructions(input.nextLine(), art, articleCommandManager));

				commandManager.executeCmd(new AddCommandToEditor(editor, art));
				System.out.println("Article added to the article.");
			} catch (Exception e) {
				System.out.println("Invalid Input: The level should be positive or higher than the level of the current article");
			}

		}else if(instruction.equals("find content")){
			this.findContentInstruction();

		}else if(instruction.equals("output html")){
			this.outputHtmlInstruction();

		}else if(instruction.equals("exit")){
			return false;
		}else if(instruction.equals("import json")){
			this.importJsonInstruction();
		}else if(instruction.equals("undo")){
			commandManager.undoCmd();
		}else if(instruction.equals("undo")){
			commandManager.redoCmd();
		}else{
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

		return article;
	}

	private void printArticleInstructions() {
		System.out.println("Please enter the following instruction to edit the article");
		System.out.println("  1. 'add title': to add a title to the article");
		System.out.println("  2. 'add paragraph': to add a paragraph to the article");
		System.out.println("  3. 'add article': to add an article to the article");
		System.out.println("  4. 'undo': to undo the previous 'add' instruction");
		System.out.println("  5. 'redo': to redo the previous undo instruction");
		System.out.println("  6. 'exit': to exit the process");
	}

	private boolean handleArticleInstructions(String instruction, Article article, CommandManager articleCommandManager) {
		if(instruction.equals("add article")) {
			CommandManager newArticleCommandManager = new CommandManager();
			Article articleTemp = (Article) addArticleInstruction(article.getLevel());
			if(articleTemp == null) return true;
			do{
				printArticleInstructions();
			}while(handleArticleInstructions(input.nextLine(), articleTemp, newArticleCommandManager));
			articleCommandManager.executeCmd(new AddCommandToArticle(article, articleTemp));
			System.out.println("Article added to the article.");
		}else if(instruction.equals("add paragraph")) {
			articleCommandManager.executeCmd(new AddCommandToArticle(article, addParagraphInstruction()));
			System.out.println("Paragraph added to the article.");
		}else if(instruction.equals("add title")) {
			articleCommandManager.executeCmd(new AddCommandToArticle(article, addTitleInstruction()));
			System.out.println("Title added to the article.");
		}else if (instruction.equals("undo")){
			articleCommandManager.undoCmd();
		}else if (instruction.equals("redo")){
			articleCommandManager.redoCmd();
		}else if (instruction.equals("exit")){
			return false;
		}else{
			System.out.println("Invalid instruction");
			return true;
		}
		return true;
	}

	private void findContentInstruction() {
		System.out.print("Enter the word you want to find: ");
		String target = input.nextLine();
		editor.findContent(target);
	}

	private void outputHtmlInstruction() {
		System.out.print("Enter the file path you want to output: ");
		String outputPath = input.nextLine();
		editor.exportDocumentAsHtmlFile(outputPath);
	}

	private void importJsonInstruction() {
		System.out.print("Enter the file path you want to import: ");
		String filePath = input.nextLine();
		editor.importDocumentFromJsonFile(filePath);
	 }
}