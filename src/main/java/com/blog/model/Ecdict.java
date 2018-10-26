package com.blog.model;

import javax.persistence.*;

public class Ecdict {

    private String word;

    private String phonetic;

    private String definition;

    private String translation;

    private String pos;

    private String collins;

    private String oxford;

    private String tag;

    private String bnc;

    private String frq;

    private String exchange;

    private String detail;

    private String audio;

    /**
     * @return word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word
     */
    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    /**
     * @return phonetic
     */
    public String getPhonetic() {
        return phonetic;
    }

    /**
     * @param phonetic
     */
    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic == null ? null : phonetic.trim();
    }

    /**
     * @return definition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * @param definition
     */
    public void setDefinition(String definition) {
        this.definition = definition == null ? null : definition.trim();
    }

    /**
     * @return translation
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * @param translation
     */
    public void setTranslation(String translation) {
        this.translation = translation == null ? null : translation.trim();
    }

    /**
     * @return pos
     */
    public String getPos() {
        return pos;
    }

    /**
     * @param pos
     */
    public void setPos(String pos) {
        this.pos = pos == null ? null : pos.trim();
    }

    /**
     * @return collins
     */
    public String getCollins() {
        return collins;
    }

    /**
     * @param collins
     */
    public void setCollins(String collins) {
        this.collins = collins == null ? null : collins.trim();
    }

    /**
     * @return oxford
     */
    public String getOxford() {
        return oxford;
    }

    /**
     * @param oxford
     */
    public void setOxford(String oxford) {
        this.oxford = oxford == null ? null : oxford.trim();
    }

    /**
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * @return bnc
     */
    public String getBnc() {
        return bnc;
    }

    /**
     * @param bnc
     */
    public void setBnc(String bnc) {
        this.bnc = bnc == null ? null : bnc.trim();
    }

    /**
     * @return frq
     */
    public String getFrq() {
        return frq;
    }

    /**
     * @param frq
     */
    public void setFrq(String frq) {
        this.frq = frq == null ? null : frq.trim();
    }

    /**
     * @return exchange
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * @param exchange
     */
    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    /**
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * @return audio
     */
    public String getAudio() {
        return audio;
    }

    /**
     * @param audio
     */
    public void setAudio(String audio) {
        this.audio = audio == null ? null : audio.trim();
    }
}