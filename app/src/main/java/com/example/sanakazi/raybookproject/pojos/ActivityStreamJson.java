package com.example.sanakazi.raybookproject.pojos;

import java.util.ArrayList;

/**
 * Created by SanaKazi on 9/12/2016.
 */
public class ActivityStreamJson
{
    private DataJson data;
    public DataJson getData() {
        return data;
    }

    public void setData(DataJson data) {
        this.data = data;
    }

    public class DataJson {
        int tweetCount, blogCount, systemCount;
        ArrayList<SortedFeedJson> sortedFeed;

        public int getTweetCount() {
            return tweetCount;
        }

        public void setTweetCount(int tweetCount) {
            this.tweetCount = tweetCount;
        }

        public int getBlogCount() {
            return blogCount;
        }

        public void setBlogCount(int blogCount) {
            this.blogCount = blogCount;
        }

        public int getSystemCount() {
            return systemCount;
        }

        public void setSystemCount(int systemCount) {
            this.systemCount = systemCount;
        }

        public ArrayList<SortedFeedJson> getSortedFeed() {
            return sortedFeed;
        }

        public void setSortedFeed(ArrayList<SortedFeedJson> sortedFeed) {
            this.sortedFeed = sortedFeed;
        }



        public class SortedFeedJson {
            String profileImageURL;
            String text;
            String tweetDate;
            String userName;
            String tweetId;
            String type;
            String title;
            String featuredImageURL;
            ArrayList<MediaJson> media;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFeaturedImageURL() {
                return featuredImageURL;
            }

            public void setFeaturedImageURL(String featuredImageURL) {
                this.featuredImageURL = featuredImageURL;
            }

            public String getProfileImageURL() {
                return profileImageURL;
            }

            public void setProfileImageURL(String profileImageURL) {
                this.profileImageURL = profileImageURL;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getTweetDate() {
                return tweetDate;
            }

            public void setTweetDate(String tweetDate) {
                this.tweetDate = tweetDate;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getTweetId() {
                return tweetId;
            }

            public void setTweetId(String tweetId) {
                this.tweetId = tweetId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public ArrayList<MediaJson> getMedia() {
                return media;
            }

            public void setMedia(ArrayList<MediaJson> media) {
                this.media = media;
            }

            public class MediaJson {
                String expandedURL, mediaURL, mediaText, mediaType;

                public String getExpandedURL() {
                    return expandedURL;
                }

                public void setExpandedURL(String expandedURL) {
                    this.expandedURL = expandedURL;
                }

                public String getMediaURL() {
                    return mediaURL;
                }

                public void setMediaURL(String mediaURL) {
                    this.mediaURL = mediaURL;
                }

                public String getMediaText() {
                    return mediaText;
                }

                public void setMediaText(String mediaText) {
                    this.mediaText = mediaText;
                }

                public String getMediaType() {
                    return mediaType;
                }

                public void setMediaType(String mediaType) {
                    this.mediaType = mediaType;
                }
            }
        }

    }
}
