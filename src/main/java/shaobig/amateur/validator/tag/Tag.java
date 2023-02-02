package shaobig.amateur.validator.tag;

import java.util.Locale;

public class Tag {

    private TagType tagType;
    private String value;

    public Tag(TagType tagType, String value) {
        this.tagType = tagType;
        this.value = value;
    }

    public TagType getTagType() {
        return tagType;
    }

    public String getTagTypeInLowerCase() {
        return getTagType().name().toLowerCase(Locale.ROOT);
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
