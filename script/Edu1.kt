package org.thefproject.fedu

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class Edu1 : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {

        val views = RemoteViews(context.packageName, R.layout.edu1)





        views.setImageViewResource(R.id.widget_enter,
            R.drawable._d_books_icon_for_educational_app_with_thematic_dimensions_removebg_preview
        )

        appWidgetManager.updateAppWidget(appWidgetId, views)

    }
}