package com.pan.dictionary.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:08
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_notes")
public class Note {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("note_id")
    private Integer noteId;
    @TableField("word_id")
    private Integer wordId;
    private String word;
    private String pronunciation;
    private String mean;
    private String sentence;
    @TableField("sentence_translate")
    private String sentenceTranslate;
    private String note;
    private Integer language;

    public Note(Integer notebookId, TransMsg transMsg, Integer language) {
        this.id = null;
        this.noteId = notebookId;
        this.wordId = null;
        this.word = transMsg.getWord();
        this.mean = transMsg.getWord();
        this.sentence = transMsg.getSentence();
        this.sentenceTranslate = transMsg.getSentenceTranslate();
        this.note = transMsg.getNote();
        this.language = language;
    }
}
