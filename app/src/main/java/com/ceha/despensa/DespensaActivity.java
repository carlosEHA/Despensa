package com.ceha.despensa;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DespensaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despensa);

        textColorNormal = getResources().getColor(R.color.text_black);
        textColorSelected = getResources().getColor(R.color.text_highlighted);

        profile_pager = (ViewPager) findViewById(R.id.profile_pager);

        //Medal tab
        tab_medal_button = (LinearLayout) findViewById(R.id.tab_medal_button);
        tab_medal_label = (TextView) findViewById(R.id.tab_medal_label);

        //Ranking tab
        tab_ranking_button = (LinearLayout) findViewById(R.id.tab_ranking_button);
        tab_ranking_label = (TextView) findViewById(R.id.tab_ranking_label);

        //Avatar tab
        tab_avatar_button = (LinearLayout) findViewById(R.id.tab_avatar_button);
        tab_avatar_label = (TextView) findViewById(R.id.tab_avatar_label);

        tab_medal_label.setTextColor(textColorSelected);

        profile_pager.setAdapter(new DespensaAdapter(getSupportFragmentManager(), this));
        profile_pager.setCurrentItem(0);
        profile_pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        onTabClick(tab_medal_button, tab_medal_label,
                                tab_ranking_button, tab_ranking_label,
                                tab_avatar_button, tab_avatar_label);
                        profile_pager.setCurrentItem(0, true);
                        break;

                    case 1:
                        onTabClick(tab_ranking_button, tab_ranking_label,
                                tab_avatar_button, tab_avatar_label,
                                tab_medal_button, tab_medal_label);
                        profile_pager.setCurrentItem(1, true);
                        break;

                    case 2:
                        onTabClick(tab_avatar_button, tab_avatar_label,
                                tab_ranking_button, tab_ranking_label,
                                tab_medal_button, tab_medal_label);
                        profile_pager.setCurrentItem(2, true);
                        break;
                }
            }
        });
    }

    ViewPager profile_pager;

    private int textColorNormal;
    private int textColorSelected;

    //Medal tab / Ranking tab / Avatar tab
    LinearLayout tab_medal_button, tab_ranking_button, tab_avatar_button;
    TextView tab_medal_label, tab_ranking_label, tab_avatar_label;

    public void onBackClick(View view) {
        finish();
    }

    public void onMedalClick(View view) {

        onTabClick(tab_medal_button, tab_medal_label,
                tab_ranking_button, tab_ranking_label,
                tab_avatar_button, tab_avatar_label);
        profile_pager.setCurrentItem(0, true);
    }

    public void onRankingClick(View view) {

        onTabClick(tab_ranking_button, tab_ranking_label,
                tab_avatar_button, tab_avatar_label,
                tab_medal_button, tab_medal_label);
        profile_pager.setCurrentItem(1, true);
    }

    public void onAvatarClick(View view) {

        onTabClick(tab_avatar_button, tab_avatar_label,
                tab_ranking_button, tab_ranking_label,
                tab_medal_button, tab_medal_label);
        profile_pager.setCurrentItem(2, true);
    }

    private void onTabClick(LinearLayout clickedLyt, TextView clickedTxtView,
                            LinearLayout unclicked1Lyt, TextView unclicked1TxtView,
                            LinearLayout unclicked2Lyt, TextView unclicked2TxtView) {

        clickedLyt.setEnabled(false);
        clickedLyt.setSelected(true);
        clickedTxtView.setTextColor(textColorSelected);

        unclicked1Lyt.setSelected(false);
        unclicked1Lyt.setEnabled(true);
        unclicked1TxtView.setTextColor(textColorNormal);

        unclicked2Lyt.setSelected(false);
        unclicked2Lyt.setEnabled(true);
        unclicked2TxtView.setTextColor(textColorNormal);

    }
}
