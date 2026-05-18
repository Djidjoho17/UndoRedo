package hw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



public class Controller {

    @FXML
    private Label countLbl;

    @FXML
    private Label undoStackLbl;
    @FXML
    private Label redoStackLbl;

    @FXML
    private Label tokenLbl;

    @FXML
    private Label writingLbl;

    private Stack<String> undoStack;
    private Stack<String> redoStack;

    private String currentToken;

    /**
     * @param event
     */
    @FXML
    void keyHandler(KeyEvent event) {
// CTRL + Z → Undo
        if (event.isControlDown() && event.getCode() == KeyCode.Z) {
            System.out.println("Undo");
            performUndo();
            return;
        }

        // CTRL + Y → Redo
        if (event.isControlDown() && event.getCode() == KeyCode.Y) {
            System.out.println("Redo");
            performRedo();
            return;
        }

        // SPACE → finalize token
        if (event.getCode() == KeyCode.SPACE) {
            System.out.println("SPACE pressed");
            finalizeToken();
            return;
        }

        // BACKSPACE → remove last char of current token
        if (event.getCode() == KeyCode.BACK_SPACE) {
            System.out.println("BACKSPACE pressed");
            if (!currentToken.isEmpty()) {
                currentToken = currentToken.substring(0, currentToken.length() - 1);
            } else if (!undoStack.isEmpty()) {
                String removed = undoStack.pop();
                redoStack.push(removed);

                String text = writingLbl.getText().trim();
                int lastSpace = text.lastIndexOf(" ");
                if (lastSpace == -1) {
                    writingLbl.setText("");
                } else {
                    writingLbl.setText(text.substring(0, lastSpace + 1));
                }
            }

            updateUI();
            return;

        }
        // Regular character input
        String typed = event.getText();
        if (typed != null && typed.length() > 0 && typed.charAt(0) >= 32) {
            currentToken += typed;
            updateUI();
        }
    }

        private void finalizeToken () {
            if (!currentToken.isEmpty()) {
                undoStack.push(currentToken);
                redoStack.clear();

                writingLbl.setText(writingLbl.getText() + currentToken + " ");
                currentToken = "";
            }
            updateUI();
        }

        private void performUndo () {
            if (!undoStack.isEmpty()) {
                String token = undoStack.pop();
                redoStack.push(token);

                // Remove last token from writingLbl
                String text = writingLbl.getText().trim();
                int lastSpace = text.lastIndexOf(" ");
                if (lastSpace == -1) {
                    writingLbl.setText("");
                } else {
                    writingLbl.setText(text.substring(0, lastSpace + 1));
                }
            }
            updateUI();
        }

        private void performRedo () {
            if (!redoStack.isEmpty()) {
                String token = redoStack.pop();
                undoStack.push(token);

                writingLbl.setText(writingLbl.getText() + token + " ");
            }
            updateUI();
        }

        private void updateUI () {
            tokenLbl.setText(currentToken);
            undoStackLbl.setText(undoStack.toString());
            redoStackLbl.setText(redoStack.toString());

            // Count words
            String trimmed = writingLbl.getText().trim();
            if (trimmed.isEmpty()) {
                countLbl.setText("0");
            } else {
                countLbl.setText(String.valueOf(trimmed.split("\\s+").length));
            }
        }


        @FXML
        void initialize () {
            undoStack = new Stack<>();
            redoStack = new Stack<>();
            currentToken = "";
            updateUI();

        }
    }
