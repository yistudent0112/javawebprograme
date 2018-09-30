package com.imooc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.imooc.dao.ImportWordDao;
import com.imooc.entity.Word;

public class WordService {
	public static Word imp(ImportWordDao wordDao) {
		Word word = new Word();
		word.setTitle(wordDao.getTitle());
		HWPFDocument document = null;
		try {
			document = new HWPFDocument(wordDao.getWord().getInputStream());
			word.setContext(document.getDocumentText().replace("\r", "<br/>"));
		} catch (IllegalArgumentException iae) {
			System.out.println("这可能是一个07版的word");
			XWPFDocument document1;
			try {
				document1 = new XWPFDocument(wordDao.getWord().getInputStream());
				List<XWPFParagraph> list = document1.getParagraphs();
				StringBuffer sb = new StringBuffer();
				for (XWPFParagraph temp : list) {
					sb.append(temp.getText());
					sb.append("<br/>");
				}
				// System.out.println(sb.toString());
				word.setContext(sb.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			word.setMessage("word解析异常");
			return word;
			// e.printStackTrace();
		}

		return word;

	}

	public static XWPFDocument exp(Map<String, String> replaceMap) {
		XWPFDocument docx = null;
		try {
			docx = new XWPFDocument(new FileInputStream(new File("F:\\JavaWeb程序\\InputAndOutput\\导出文档模板.dotx")));
			String word = null;
			List<XWPFParagraph> paragraph = docx.getParagraphs();
			for (XWPFParagraph temp : paragraph) {
				List<XWPFRun> runs = temp.getRuns();
				for (XWPFRun run : runs) {
					word = run.getText(run.getTextPosition());
					for (Map.Entry<String, String> map : replaceMap.entrySet()) {
						word=word.replace(map.getKey(), map.getValue());
						System.out.println(map);
					}
					run.setText(word, 0);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return docx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
