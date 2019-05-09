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
     * <p>Title: 文本选择器.</p>
     * <p>Description: 通过文本全匹配定位元素.</p>
     *
     * @param text text全称
     * @return 返回UiSelector对象
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
     * <p>Title: textContains选择器.</p>
     * <p>Description: 通过textContains定位元素.</p>
     *
     * @param text 包含的text名称
     * @return 返回UiSelector对象
     */
    public UiSelector textContains(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setTextContains(text);
        selector.setMask(SELECTOR_TEXTCONTAINS);
        return selector;
    }


    /**
     *
     * <p>Title: textStartsWith选择器.</p>
     * <p>Description: 通过textStartsWith定位元素.</p>
     *
     * @param text text开始的名称
     * @return 返回UiSelector对象
     */
    public UiSelector textStartsWith(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setTextStartsWith(text);;
        selector.setMask(SELECTOR_TEXTSTARTSWITH);
        return selector;
    }


    /**
     *
     * <p>Title: textMatches选择器.</p>
     * <p>Description: 通过textMatches定位元素.</p>
     *
     * @param regex 待定位的text的正则表达式
     * @return 返回UiSelector对象
     */
    public UiSelector textMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setTextMatches(regex);;
        selector.setMask(SELECTOR_TEXTMATCHES);
        return selector;
    }

    /**
     *
     * <p>Title: className选择器.</p>
     * <p>Description: 通过className定位元素.</p>
     *
     * @param text className名称
     * @return 返回UiSelector对象
     */
    public UiSelector className(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setClassName(text);
        selector.setMask(SELECTOR_CLASSNAME);
        return selector;
    }


    /**
     *
     * <p>Title: classNameMatches选择器.</p>
     * <p>Description: 通过classNameMatches定位元素.</p>
     *
     * @param regex classNameMatches名称
     * @return 返回UiSelector对象
     */
    public UiSelector classNameMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setClassNameMatches(regex);;
        selector.setMask(SELECTOR_CLASSNAMEMATCHES);
        return selector;
    }



    /**
     *
     * <p>Title: description选择器.</p>
     * <p>Description: 通过description全匹配定位元素.</p>
     *
     * @param description 全称
     * @return 返回UiSelector对象
     */
    public UiSelector description(String description) {
        UiSelector selector = new UiSelector(this);
        selector.setDescription(description);
        selector.setMask(UiSelector.SELECTOR_DESCRIPTION);
        return selector;
    }


    /**
     *
     * <p>Title: descriptionContains选择器.</p>
     * <p>Description: 通过descriptionContains定位元素.</p>
     *
     * @param text 包含的description名称
     * @return 返回UiSelector对象
     */
    public UiSelector descriptionContains(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setDescriptionContains(text);
        selector.setMask(SELECTOR_DESCRIPTIONCONTAINS);
        return selector;
    }


    /**
     *
     * <p>Title: descriptionStartsWith选择器.</p>
     * <p>Description: 通过descriptionStartsWith定位元素.</p>
     *
     * @param text description开始的名称
     * @return 返回UiSelector对象
     */
    public UiSelector descriptionStartsWith(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setDescriptionStartsWith(text);;
        selector.setMask(SELECTOR_DESCRIPTIONSTARTSWITH);
        return selector;
    }


    /**
     *
     * <p>Title: descriptionMatches选择器.</p>
     * <p>Description: 通过descriptionMatches定位元素.</p>
     *
     * @param regex 待定位的description的正则表达式
     * @return 返回UiSelector对象
     */
    public UiSelector descriptionMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setDescriptionMatches(regex);;
        selector.setMask(SELECTOR_DESCRIPTIONMATCHES);
        return selector;
    }


    /**
     *
     * <p>Title: checkable选择器.</p>
     * <p>Description: 通过checkable定位元素.</p>
     *
     * @param ischeckable 是否checkable
     * @return 返回UiSelector对象
     */
    public UiSelector checkable(boolean ischeckable) {
        UiSelector selector = new UiSelector(this);
        selector.setCheckable(ischeckable);;
        selector.setMask(SELECTOR_CHECKABLE);
        return selector;
    }

    /**
     *
     * <p>Title: checked选择器.</p>
     * <p>Description: 通过checked定位元素.</p>
     *
     * @param ischecked 是否checked
     * @return 返回UiSelector对象
     */
    public UiSelector checked(boolean ischecked) {
        UiSelector selector = new UiSelector(this);
        selector.setCheckable(ischecked);;
        selector.setMask(SELECTOR_CHECKED);
        return selector;
    }


    /**
     *
     * <p>Title: clickable选择器.</p>
     * <p>Description: 通过clickable定位元素.</p>
     *
     * @param isclickable 是否clickable
     * @return 返回UiSelector对象
     */
    public UiSelector clickable(boolean isclickable) {
        UiSelector selector = new UiSelector(this);
        selector.setClickable(isclickable);;
        selector.setMask(SELECTOR_CLICKABLE);
        return selector;
    }


    /**
     *
     * <p>Title: longclickable选择器.</p>
     * <p>Description: 通过longclickable定位元素.</p>
     *
     * @param islongclickable 是否longclickable
     * @return 返回UiSelector对象
     */
    public UiSelector longclickable(boolean islongclickable) {
        UiSelector selector = new UiSelector(this);
        selector.setLongClickable(islongclickable);;
        selector.setMask(SELECTOR_LONGCLICKABLE);
        return selector;
    }

    /**
     *
     * <p>Title: scrollable选择器.</p>
     * <p>Description: 通过scrollable定位元素.</p>
     *
     * @param isscrollable 是否scrollable
     * @return 返回UiSelector对象
     */
    public UiSelector scrollable(boolean isscrollable) {
        UiSelector selector = new UiSelector(this);
        selector.setScrollable(isscrollable);;
        selector.setMask(SELECTOR_SCROLLABLE);
        return selector;
    }

    /**
     *
     * <p>Title: enabled选择器.</p>
     * <p>Description: 通过enabled定位元素.</p>
     *
     * @param isenabled 是否enabled
     * @return 返回UiSelector对象
     */
    public UiSelector enabled(boolean isenabled) {
        UiSelector selector = new UiSelector(this);
        selector.setEnabled(isenabled);;
        selector.setMask(SELECTOR_ENABLED);
        return selector;
    }

    /**
     *
     * <p>Title: focusable选择器.</p>
     * <p>Description: 通过focusable定位元素.</p>
     *
     * @param isfocusable 是否focusable
     * @return 返回UiSelector对象
     */
    public UiSelector focusable(boolean isfocusable) {
        UiSelector selector = new UiSelector(this);
        selector.setFocusable(isfocusable);;
        selector.setMask(SELECTOR_FOCUSABLE);
        return selector;
    }

    /**
     *
     * <p>Title: focused选择器.</p>
     * <p>Description: 通过focused定位元素.</p>
     *
     * @param isfocused 是否focused
     * @return 返回UiSelector对象
     */
    public UiSelector focused(boolean isfocused) {
        UiSelector selector = new UiSelector(this);
        selector.setFocused(isfocused);;
        selector.setMask(SELECTOR_FOCUSED);
        return selector;
    }

    /**
     *
     * <p>Title: selected选择器.</p>
     * <p>Description: 通过selected定位元素.</p>
     *
     * @param isselected 是否selected
     * @return 返回UiSelector对象
     */
    public UiSelector selected(boolean isselected) {
        UiSelector selector = new UiSelector(this);
        selector.setSelected(isselected);;
        selector.setMask(SELECTOR_SELECTED);
        return selector;
    }

    /**
     *
     * <p>Title: packageName选择器.</p>
     * <p>Description: 通过packageName定位元素.</p>
     *
     * @param text packageName
     * @return 返回UiSelector对象
     */
    public UiSelector packageName(String text) {
        UiSelector selector = new UiSelector(this);
        selector.setPackageName(text);;
        selector.setMask(SELECTOR_PACKAGENAME);
        return selector;
    }

    /**
     *
     * <p>Title: packageNameMatches选择器.</p>
     * <p>Description: 通过packageNameMatches定位元素.</p>
     *
     * @param  regex packageNameMatches
     * @return 返回UiSelector对象
     */
    public UiSelector packageNameMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setPackageNameMatches(regex);;
        selector.setMask(SELECTOR_PACKAGENAMEMATCHES);
        return selector;
    }

    /**
     *
     * <p>Title: resourceId选择器.</p>
     * <p>Description: 通过resourceId定位元素.</p>
     *
     * @param id resourceId
     * @return 返回UiSelector对象
     */
    public UiSelector resourceId(String id) {
        UiSelector selector = new UiSelector(this);
        selector.setResourceId(id);;
        selector.setMask(SELECTOR_RESOURCEID);
        return selector;
    }

    /**
     *
     * <p>Title: resourceIdMatches选择器.</p>
     * <p>Description: 通过resourceIdMatches定位元素.</p>
     *
     * @param regex resourceIdMatches
     * @return 返回UiSelector对象
     */
    public UiSelector resourceIdMatches(String regex) {
        UiSelector selector = new UiSelector(this);
        selector.setResourceIdMatches(regex);;
        selector.setMask(SELECTOR_RESOURCEIDMATCHES);
        return selector;
    }

    /**
     *
     * <p>Title: index选择器.</p>
     * <p>Description: 通过index定位元素.</p>
     *
     * @param i index
     * @return 返回UiSelector对象
     */
    public UiSelector index(int i) {
        UiSelector selector = new UiSelector(this);
        selector.setIndex(i);;
        selector.setMask(SELECTOR_INDEX);
        return selector;
    }

    /**
     *
     * <p>Title: instance选择器.</p>
     * <p>Description: 通过instance定位元素.</p>
     *
     * @param i instance index
     * @return 返回UiSelector对象
     */
    public UiSelector instance(int i) {
        UiSelector selector = new UiSelector(this);
        selector.setInstance(i);;
        selector.setMask(SELECTOR_INSTANCE);
        return selector;
    }
}
