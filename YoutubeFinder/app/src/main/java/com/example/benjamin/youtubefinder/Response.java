package com.example.benjamin.youtubefinder;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    private String kind;
    private List<ItemsBean> items;
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public List<ItemsBean> getItems() {
        return items;
    }

    public static class ItemsBean {
        private String kind;
        private IdBean id;
        private SnippetBean snippet;
        public String getKind() {
            return kind;
        }
        public void setKind(String kind) {
            this.kind = kind;
        }
        public IdBean getId() {
            return id;
        }
        public void setId(IdBean id) {
            this.id = id;
        }
        public SnippetBean getSnippet() {
            return snippet;
        }

        public static class IdBean {
            private String kind;
            private String videoId;
            public String getKind() {
                return kind;
            }
            public void setKind(String kind) {
                this.kind = kind;
            }
            public String getVideoId() {
                return videoId;
            }
        }
        public static class SnippetBean {
            private String title;
            private String description;
            private ThumbnailsBean thumbnails;
            private String channelTitle;
            public String getTitle() {
                return title;
            }
            public String getDescription() {
                return description;
            }
            public ThumbnailsBean getThumbnails() {
                return thumbnails;
            }
            public String getChannelTitle() {
                return channelTitle;
            }
            public static class ThumbnailsBean {

                @SerializedName("default")
                private HighBean high;
                public HighBean getHigh() {
                    return high;
                }

                public static class HighBean {
                    private String url;
                    public String getUrl() {
                        return url;
                    }
                }
            }
        }
    }
}
