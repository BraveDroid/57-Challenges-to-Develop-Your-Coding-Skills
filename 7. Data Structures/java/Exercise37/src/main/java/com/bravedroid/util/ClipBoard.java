package com.bravedroid.util;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.awt.*;
import java.awt.datatransfer.StringSelection;


public class ClipBoard {

  public static void addToClipBoard1(String password) {
    StringSelection selection = new StringSelection(password);
    java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, selection);
  }

  public static void addToClipBoard2(String password) {
    ClipboardContent content = new ClipboardContent();
    content.putString(password);
    Clipboard.getSystemClipboard().setContent(content);
  }
}
