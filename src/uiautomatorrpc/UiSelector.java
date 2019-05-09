package uiautomatorrpc;
import java.util.HashMap;
/**
 * Created by qiumin on 2015/8/14.
 */
public class UiSelector {
    private String   _text;
    private String   _textContains;
    private String   _textMatches;
    private String   _textStartsWith;
    private String   _className;
    private String   _classNameMatches;
    private String   _description;
    private String   _descriptionContains;
    private String   _descriptionMatches;
    private String   _descriptionStartsWith;
    private boolean  _checkable;
    private boolean  _checked;
    private boolean  _clickable;
    private boolean  _longClickable;
    private boolean  _scrollable;
    private boolean  _enabled;
    private boolean  _focusable;
    private boolean  _focused;
    private boolean  _selected;
    private String   _packageName;
    private String   _packageNameMatches;
    private String   _resourceId;
    private String   _resourceIdMatches;
    private int      _index;
    private int      _instance;

    private UiSelector[] _childOrSiblingSelector = new UiSelector[]{};
    private String[] _childOrSibling = new String[]{};

    private long     _mask;

    public static final long SELECTOR_TEXT = 0x01;
    public static final long SELECTOR_TEXTCONTAINS = 0x02;
    public static final long SELECTOR_TEXTMATCHES = 0x04;
    public static final long SELECTOR_TEXTSTARTSWITH = 0x08;
    public static final long SELECTOR_CLASSNAME = 0x10;
    public static final long SELECTOR_CLASSNAMEMATCHES = 0x20;
    public static final long SELECTOR_DESCRIPTION = 0x40;
    public static final long SELECTOR_DESCRIPTIONCONTAINS = 0x80;
    public static final long SELECTOR_DESCRIPTIONMATCHES = 0x0100;
    public static final long SELECTOR_DESCRIPTIONSTARTSWITH = 0x0200;
    public static final long SELECTOR_CHECKABLE = 0x0400;
    public static final long SELECTOR_CHECKED = 0x0800;
    public static final long SELECTOR_CLICKABLE = 0x1000;
    public static final long SELECTOR_LONGCLICKABLE = 0x2000;
    public static final long SELECTOR_SCROLLABLE = 0x4000;
    public static final long SELECTOR_ENABLED = 0x8000;
    public static final long SELECTOR_FOCUSABLE = 0x010000;
    public static final long SELECTOR_FOCUSED = 0x020000;
    public static final long SELECTOR_SELECTED = 0x040000;
    public static final long SELECTOR_PACKAGENAME = 0x080000;
    public static final long SELECTOR_PACKAGENAMEMATCHES = 0x100000;
    public static final long SELECTOR_RESOURCEID = 0x200000;
    public static final long SELECTOR_RESOURCEIDMATCHES = 0x400000;
    public static final long SELECTOR_INDEX = 0x800000;
    public static final long SELECTOR_INSTANCE = 0x01000000;

    UiSelector(UiSelector selector) {
        mSelectorAttributes = selector.cloneSelector().mSelectorAttributes;

    }


    public UiSelector() {

    }


    private HashMap<Long, Object> mSelectorAttributes = new HashMap<Long,Object>();

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        this._text = text;
    }

    public String getClassName() {
        return _className;
    }

    public void setClassName(String className) {
        this._className = className;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public String getTextContains() {
        return _textContains;
    }

    public void setTextContains(String _textContains) {
        this._textContains = _textContains;
    }

    public String getTextMatches() {
        return _textMatches;
    }

    public void setTextMatches(String _textMatches) {
        this._textMatches = _textMatches;
    }

    public String getTextStartsWith() {
        return _textStartsWith;
    }

    public void setTextStartsWith(String _textStartsWith) {
        this._textStartsWith = _textStartsWith;
    }

    public String getClassNameMatches() {
        return _classNameMatches;
    }

    public void setClassNameMatches(String _classNameMatches) {
        this._classNameMatches = _classNameMatches;
    }

    public String getDescriptionContains() {
        return _descriptionContains;
    }

    public void setDescriptionContains(String _descriptionContains) {
        this._descriptionContains = _descriptionContains;
    }

    public String getDescriptionMatches() {
        return _descriptionMatches;
    }

    public void setDescriptionMatches(String _descriptionMatches) {
        this._descriptionMatches = _descriptionMatches;
    }

    public String getDescriptionStartsWith() {
        return _descriptionStartsWith;
    }

    public void setDescriptionStartsWith(String _descriptionStartsWith) {
        this._descriptionStartsWith = _descriptionStartsWith;
    }

    public boolean isCheckable() {
        return _checkable;
    }

    public void setCheckable(boolean _checkable) {
        this._checkable = _checkable;
    }

    public boolean isChecked() {
        return _checked;
    }

    public void setChecked(boolean _checked) {
        this._checked = _checked;
    }

    public boolean isClickable() {
        return _clickable;
    }

    public void setClickable(boolean _clickable) {
        this._clickable = _clickable;
    }

    public boolean isScrollable() {
        return _scrollable;
    }

    public void setScrollable(boolean _scrollable) {
        this._scrollable = _scrollable;
    }

    public boolean isLongClickable() {
        return _longClickable;
    }

    public void setLongClickable(boolean _longClickable) {
        this._longClickable = _longClickable;
    }

    public boolean isEnabled() {
        return _enabled;
    }

    public void setEnabled(boolean _enabled) {
        this._enabled = _enabled;
    }

    public boolean isFocusable() {
        return _focusable;
    }

    public void setFocusable(boolean _focusable) {
        this._focusable = _focusable;
    }

    public boolean isFocused() {
        return _focused;
    }

    public void setFocused(boolean _focused) {
        this._focused = _focused;
    }

    public boolean isSelected() {
        return _selected;
    }

    public void setSelected(boolean _selected) {
        this._selected = _selected;
    }

    public String getPackageName() {
        return _packageName;
    }

    public void setPackageName(String _packageName) {
        this._packageName = _packageName;
    }

    public String getPackageNameMatches() {
        return _packageNameMatches;
    }

    public void setPackageNameMatches(String _packageNameMatches) {
        this._packageNameMatches = _packageNameMatches;
    }

    public String getResourceId() {
        return _resourceId;
    }

    public void setResourceId(String _resourceId) {
        this._resourceId = _resourceId;
    }

    public String getResourceIdMatches() {
        return _resourceIdMatches;
    }

    public void setResourceIdMatches(String _resourceIdMatches) {
        this._resourceIdMatches = _resourceIdMatches;
    }

    public int getIndex() {
        return _index;
    }

    public void setIndex(int _index) {
        this._index = _index;
    }

    public int getInstance() {
        return _instance;
    }

    public void setInstance(int _instance) {
        this._instance = _instance;
    }

    public long getMask() {
        return _mask;
    }

    public void setMask(long _mask) {
        this._mask = _mask;
    }

    public UiSelector[] getChildOrSiblingSelector() {
        return _childOrSiblingSelector;
    }

    public void setChildOrSiblingSelector(UiSelector[] _childOrSiblingSelector) {
        this._childOrSiblingSelector = _childOrSiblingSelector;
    }

    public String[] getChildOrSibling() {
        return _childOrSibling;
    }

    public void setChildOrSibling(String[] _childOrSibling) {
        this._childOrSibling = _childOrSibling;
    }



    @SuppressWarnings("unchecked")
    protected UiSelector cloneSelector() {
        UiSelector ret = new UiSelector();
        ret.mSelectorAttributes = (HashMap<Long, Object>) mSelectorAttributes.clone();
        return ret;
    }

    protected UiSelector buildSelector(long selectorId,Object selectorValue){
        UiSelector selector = new UiSelector(this);
        selector.mSelectorAttributes.put(selectorId, selectorValue);
        return selector;

    }



    /**
     *
     * <p>Title: �ı�ѡ����.</p>
     * <p>Description: ͨ���ı�ȫƥ�䶨λԪ��.</p>
     *
     * @param text textȫ��
     * @return ����UiSelector����
     */
    public UiSelector text(String text) {
        // return buildSelector(SELECTOR_TEXT, text);
        UiSelector selector = new UiSelector(this);
        //selector.mSelectorAttributes.put(SELECTOR_TEXT, text);
        selector.setText(text);
        selector.setMask(SELECTOR_TEXT);
        return selector;
    }


    /**
     *
     * <p>Title: textContainsѡ����.</p>
     * <p>Description: ͨ��textContains��λԪ��.</p>
     *
     * @param text ������text����
     * @return ����UiSelector����
     */
    public UiSelector textContains(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setTextContains(text);
        selector.setMask(SELECTOR_TEXTCONTAINS);
        return selector;
    }


    /**
     *
     * <p>Title: textStartsWithѡ����.</p>
     * <p>Description: ͨ��textStartsWith��λԪ��.</p>
     *
     * @param text text��ʼ������
     * @return ����UiSelector����
     */
    public UiSelector textStartsWith(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setTextStartsWith(text);;
        selector.setMask(SELECTOR_TEXTSTARTSWITH);
        return selector;
    }


    /**
     *
     * <p>Title: textMatchesѡ����.</p>
     * <p>Description: ͨ��textMatches��λԪ��.</p>
     *
     * @param regex ����λ��text��������ʽ
     * @return ����UiSelector����
     */
    public UiSelector textMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setTextMatches(regex);;
        selector.setMask(SELECTOR_TEXTMATCHES);
        return selector;
    }

    /**
     *
     * <p>Title: classNameѡ����.</p>
     * <p>Description: ͨ��className��λԪ��.</p>
     *
     * @param text className����
     * @return ����UiSelector����
     */
    public UiSelector className(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setClassName(text);
        selector.setMask(SELECTOR_CLASSNAME);
        return selector;
    }


    /**
     *
     * <p>Title: classNameMatchesѡ����.</p>
     * <p>Description: ͨ��classNameMatches��λԪ��.</p>
     *
     * @param regex classNameMatches����
     * @return ����UiSelector����
     */
    public UiSelector classNameMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setClassNameMatches(regex);;
        selector.setMask(SELECTOR_CLASSNAMEMATCHES);
        return selector;
    }



    /**
     *
     * <p>Title: descriptionѡ����.</p>
     * <p>Description: ͨ��descriptionȫƥ�䶨λԪ��.</p>
     *
     * @param description ȫ��
     * @return ����UiSelector����
     */
    public UiSelector description(String description) {
        UiSelector selector = new UiSelector(this);
        selector.setDescription(description);
        selector.setMask(UiSelector.SELECTOR_DESCRIPTION);
        return selector;
    }


    /**
     *
     * <p>Title: descriptionContainsѡ����.</p>
     * <p>Description: ͨ��descriptionContains��λԪ��.</p>
     *
     * @param text ������description����
     * @return ����UiSelector����
     */
    public UiSelector descriptionContains(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setDescriptionContains(text);
        selector.setMask(SELECTOR_DESCRIPTIONCONTAINS);
        return selector;
    }


    /**
     *
     * <p>Title: descriptionStartsWithѡ����.</p>
     * <p>Description: ͨ��descriptionStartsWith��λԪ��.</p>
     *
     * @param text description��ʼ������
     * @return ����UiSelector����
     */
    public UiSelector descriptionStartsWith(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setDescriptionStartsWith(text);;
        selector.setMask(SELECTOR_DESCRIPTIONSTARTSWITH);
        return selector;
    }


    /**
     *
     * <p>Title: descriptionMatchesѡ����.</p>
     * <p>Description: ͨ��descriptionMatches��λԪ��.</p>
     *
     * @param regex ����λ��description��������ʽ
     * @return ����UiSelector����
     */
    public UiSelector descriptionMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setDescriptionMatches(regex);;
        selector.setMask(SELECTOR_DESCRIPTIONMATCHES);
        return selector;
    }


    /**
     *
     * <p>Title: checkableѡ����.</p>
     * <p>Description: ͨ��checkable��λԪ��.</p>
     *
     * @param ischeckable �Ƿ�checkable
     * @return ����UiSelector����
     */
    public UiSelector checkable(boolean ischeckable) {
        UiSelector selector = new UiSelector(this);
        selector.setCheckable(ischeckable);;
        selector.setMask(SELECTOR_CHECKABLE);
        return selector;
    }

    /**
     *
     * <p>Title: checkedѡ����.</p>
     * <p>Description: ͨ��checked��λԪ��.</p>
     *
     * @param ischecked �Ƿ�checked
     * @return ����UiSelector����
     */
    public UiSelector checked(boolean ischecked) {
        UiSelector selector = new UiSelector(this);
        selector.setCheckable(ischecked);;
        selector.setMask(SELECTOR_CHECKED);
        return selector;
    }


    /**
     *
     * <p>Title: clickableѡ����.</p>
     * <p>Description: ͨ��clickable��λԪ��.</p>
     *
     * @param isclickable �Ƿ�clickable
     * @return ����UiSelector����
     */
    public UiSelector clickable(boolean isclickable) {
        UiSelector selector = new UiSelector(this);
        selector.setClickable(isclickable);;
        selector.setMask(SELECTOR_CLICKABLE);
        return selector;
    }


    /**
     *
     * <p>Title: longclickableѡ����.</p>
     * <p>Description: ͨ��longclickable��λԪ��.</p>
     *
     * @param islongclickable �Ƿ�longclickable
     * @return ����UiSelector����
     */
    public UiSelector longclickable(boolean islongclickable) {
        UiSelector selector = new UiSelector(this);
        selector.setLongClickable(islongclickable);;
        selector.setMask(SELECTOR_LONGCLICKABLE);
        return selector;
    }

    /**
     *
     * <p>Title: scrollableѡ����.</p>
     * <p>Description: ͨ��scrollable��λԪ��.</p>
     *
     * @param isscrollable �Ƿ�scrollable
     * @return ����UiSelector����
     */
    public UiSelector scrollable(boolean isscrollable) {
        UiSelector selector = new UiSelector(this);
        selector.setScrollable(isscrollable);;
        selector.setMask(SELECTOR_SCROLLABLE);
        return selector;
    }

    /**
     *
     * <p>Title: enabledѡ����.</p>
     * <p>Description: ͨ��enabled��λԪ��.</p>
     *
     * @param isenabled �Ƿ�enabled
     * @return ����UiSelector����
     */
    public UiSelector enabled(boolean isenabled) {
        UiSelector selector = new UiSelector(this);
        selector.setEnabled(isenabled);;
        selector.setMask(SELECTOR_ENABLED);
        return selector;
    }

    /**
     *
     * <p>Title: focusableѡ����.</p>
     * <p>Description: ͨ��focusable��λԪ��.</p>
     *
     * @param isfocusable �Ƿ�focusable
     * @return ����UiSelector����
     */
    public UiSelector focusable(boolean isfocusable) {
        UiSelector selector = new UiSelector(this);
        selector.setFocusable(isfocusable);;
        selector.setMask(SELECTOR_FOCUSABLE);
        return selector;
    }

    /**
     *
     * <p>Title: focusedѡ����.</p>
     * <p>Description: ͨ��focused��λԪ��.</p>
     *
     * @param isfocused �Ƿ�focused
     * @return ����UiSelector����
     */
    public UiSelector focused(boolean isfocused) {
        UiSelector selector = new UiSelector(this);
        selector.setFocused(isfocused);;
        selector.setMask(SELECTOR_FOCUSED);
        return selector;
    }

    /**
     *
     * <p>Title: selectedѡ����.</p>
     * <p>Description: ͨ��selected��λԪ��.</p>
     *
     * @param isselected �Ƿ�selected
     * @return ����UiSelector����
     */
    public UiSelector selected(boolean isselected) {
        UiSelector selector = new UiSelector(this);
        selector.setSelected(isselected);;
        selector.setMask(SELECTOR_SELECTED);
        return selector;
    }

    /**
     *
     * <p>Title: packageNameѡ����.</p>
     * <p>Description: ͨ��packageName��λԪ��.</p>
     *
     * @param text packageName
     * @return ����UiSelector����
     */
    public UiSelector packageName(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setPackageName(text);;
        selector.setMask(SELECTOR_PACKAGENAME);
        return selector;
    }

    /**
     *
     * <p>Title: packageNameMatchesѡ����.</p>
     * <p>Description: ͨ��packageNameMatches��λԪ��.</p>
     *
     * @param  regex packageNameMatches
     * @return ����UiSelector����
     */
    public UiSelector packageNameMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setPackageNameMatches(regex);;
        selector.setMask(SELECTOR_PACKAGENAMEMATCHES);
        return selector;
    }

    /**
     *
     * <p>Title: resourceIdѡ����.</p>
     * <p>Description: ͨ��resourceId��λԪ��.</p>
     *
     * @param id resourceId
     * @return ����UiSelector����
     */
    public UiSelector resourceId(String id) {
        UiSelector selector = new UiSelector(this);
        selector.setResourceId(id);;
        selector.setMask(SELECTOR_RESOURCEID);
        return selector;
    }

    /**
     *
     * <p>Title: resourceIdMatchesѡ����.</p>
     * <p>Description: ͨ��resourceIdMatches��λԪ��.</p>
     *
     * @param regex resourceIdMatches
     * @return ����UiSelector����
     */
    public UiSelector resourceIdMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setResourceIdMatches(regex);;
        selector.setMask(SELECTOR_RESOURCEIDMATCHES);
        return selector;
    }

    /**
     *
     * <p>Title: indexѡ����.</p>
     * <p>Description: ͨ��index��λԪ��.</p>
     *
     * @param i index
     * @return ����UiSelector����
     */
    public UiSelector index(int i) {
        UiSelector selector = new UiSelector(this);
        selector.setIndex(i);;
        selector.setMask(SELECTOR_INDEX);
        return selector;
    }

    /**
     *
     * <p>Title: instanceѡ����.</p>
     * <p>Description: ͨ��instance��λԪ��.</p>
     *
     * @param i instance index
     * @return ����UiSelector����
     */
    public UiSelector instance(int i) {
        UiSelector selector = new UiSelector(this);
        selector.setInstance(i);;
        selector.setMask(SELECTOR_INSTANCE);
        return selector;
    }
}
