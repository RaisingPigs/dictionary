package com.pan.dictionary.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-14 13:42
 **/
@Data
@AllArgsConstructor
public class TransMsg {
    private String word;
    private String pronunciation;
    private String mean;
    private String sentence;
    private String sentenceTranslate;
    private String note;
    private String fromCode;
    private String toCode;

    public TransMsg() {
        this.fromCode = "auto";
        this.toCode = "zh";
    }

    public TransMsg(String word, String mean, String fromCode, String toCode) {
        this.word = word;
        this.pronunciation = "/" + word + "/";
        this.mean = mean;
        this.sentence = word + "    " + word + "    " + word;
        this.sentenceTranslate = mean + "    " + mean + "    " + mean;
        this.note = "无";
        this.fromCode = fromCode;
        this.toCode = toCode;
    }

    public TransMsg(Note note, String fromCode, String toCode) {
        this.word = note.getWord();
        this.pronunciation = note.getPronunciation();
        this.mean = note.getMean();
        this.sentence = note.getSentence();
        this.sentenceTranslate = note.getSentenceTranslate();
        this.note = note.getNote();
        this.fromCode = fromCode;
        this.toCode = toCode;
    }

    public TransMsg(Word word, String fromCode, String toCode) {
        this.word = word.getWord();
        this.pronunciation = word.getPronunciation();
        this.mean = word.getMean();
        this.sentence = word.getSentence();
        this.sentenceTranslate = word.getSentenceTranslate();
        this.fromCode = fromCode;
        this.toCode = toCode;
    }
}
