package com.pan.dictionary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.dictionary.bean.Note;
import com.pan.dictionary.bean.TransMsg;
import com.pan.dictionary.mapper.NoteMapper;
import com.pan.dictionary.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:00
 **/
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public Note getNoteByWordAndLanguageId(String word, Integer languageId) {
        QueryWrapper<Note> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Note::getWord, word);
        wrapper.lambda().eq(Note::getLanguage, languageId);

        return noteMapper.selectOne(wrapper);
    }

    @Override
    public void saveNoteByTransMsg(Integer notebookId, TransMsg transMsg, Integer language) {
        Note note = new Note(null, notebookId, null, transMsg.getWord(), transMsg.getPronunciation(), transMsg.getMean(), transMsg.getSentence(), transMsg.getSentenceTranslate(), transMsg.getNote(), language);
        
        noteMapper.insert(note);
    }

    @Override
    public void removeNoteByWord(String word) {
        QueryWrapper<Note> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Note::getWord, word);
        noteMapper.delete(wrapper);
    }
}
