package com.pan.dictionary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.dictionary.bean.Note;
import com.pan.dictionary.bean.TransMsg;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:00
 **/
public interface NoteService extends IService<Note> {
    Note getNoteByWordAndLanguageId(String word, Integer languageId);
    
    void saveNoteByTransMsg(Integer notebookId, TransMsg transMsg, Integer language);

    void removeNoteByWord(String word);
}
